package eugene.korovkin.stocks;

import eugene.korovkin.stocks.dto.DividendsRowDto;
import eugene.korovkin.stocks.dto.Portfolio;
import eugene.korovkin.stocks.dto.PositionDto;
import eugene.korovkin.stocks.iex.IexCloudClient;
import eugene.korovkin.stocks.iex.dto.CompanyDto;
import eugene.korovkin.stocks.iex.dto.CompanyDtoIex;
import eugene.korovkin.stocks.iex.dto.DividendsDtoIex;
import eugene.korovkin.stocks.iex.dto.PreviousDtoIex;
import eugene.korovkin.stocks.jooq.Tables;
import eugene.korovkin.stocks.jooq.tables.records.CompanyRecord;
import eugene.korovkin.stocks.model.Position;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static eugene.korovkin.stocks.jooq.Tables.COMPANY;

@Service
@RequiredArgsConstructor
public class StocksService {

    private final IexCloudClient iexCloudClient;
    private final DSLContext dsl;
    private final StocksRepository stocksRepository;

    public void updateCompanies(Set<String> symbols) {
        List<String> alreadySavedSymbols = dsl.selectFrom(COMPANY).where(COMPANY.SYMBOL.in(symbols)).fetch(COMPANY.SYMBOL);
        Collection<String> notYetSavedSymbols = CollectionUtils.subtract(symbols, alreadySavedSymbols);
        List<CompanyDtoIex> companies = notYetSavedSymbols.stream().map(iexCloudClient::getCompany).toList();
        List<Query> inserts = companies.stream().map(c -> dsl.insertInto(COMPANY, COMPANY.ID, COMPANY.INDUSTRY, COMPANY.NAME, COMPANY.SECTOR, COMPANY.SYMBOL)
                        .values(UUID.randomUUID(), c.getIndustry(), c.getCompanyName(), c.getSector(), c.getSymbol()))
                .collect(Collectors.toList());
        dsl.batch(inserts).execute();
        dsl.batchInsert();
    }

    public List<CompanyDto> getCompanies() {
        List<CompanyRecord> companyRecords = dsl.selectFrom(Tables.COMPANY).fetch();
        return companyRecords.stream().map(CompanyMapper::dtoToRecord).collect(Collectors.toList());
    }

    public Portfolio getPortfolio() {
        List<Position> positions = stocksRepository.getPositions();
        List<PositionDto> positionDtos = positions.parallelStream().map(this::getPositionDto).collect(Collectors.toList());
        return getPortfolio(positionDtos);
    }

    private PositionDto getPositionDto(Position position) {
        PreviousDtoIex previous = iexCloudClient.getPrevious(position.getSymbol());
        PositionDto dto = new PositionDto();
        dto.setSymbol(position.getSymbol());
        dto.setCompanyName(position.getCompanyName());
        dto.setQuantity(position.getQuantity());
        dto.setCurrentPrice(previous.getClose());
        dto.setTotalPrice(previous.getClose().multiply(BigDecimal.valueOf(position.getQuantity())));
        return dto;
    }

    private Portfolio getPortfolio(List<PositionDto> positionDtos) {
        Portfolio portfolio = new Portfolio();
        portfolio.setPositions(positionDtos);
        BigDecimal totalSum = positionDtos.stream().map(PositionDto::getTotalPrice).reduce(BigDecimal::add).get();
        portfolio.setTotalPrice(totalSum);
        return portfolio;
    }

    public List<DividendsRowDto> getDividends() {
        List<Position> positions = stocksRepository.getPositions();
        return positions.parallelStream().map(this::getDividendsRow).filter(r -> r.getPaymentDate() != null).sorted(Comparator.comparing(DividendsRowDto::getPaymentDate)).collect(Collectors.toList());
    }

    private DividendsRowDto getDividendsRow(Position position) {
        DividendsDtoIex previous = iexCloudClient.getNextDividends(position.getSymbol());
        DividendsRowDto dto = new DividendsRowDto();
        dto.setSymbol(position.getSymbol());
        dto.setCompanyName(position.getCompanyName());
        dto.setQuantity(position.getQuantity());
        if (previous != null && previous.getAmount() != null) {
            dto.setNextDividend(previous.getAmount());
            dto.setTotal(previous.getAmount().multiply(BigDecimal.valueOf(position.getQuantity())));
            dto.setPaymentDate(previous.getPaymentDate());
        }
        return dto;
    }
}
