package eugene.korovkin.stocks;

import eugene.korovkin.stocks.iex.IexCloudClient;
import eugene.korovkin.stocks.iex.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static eugene.korovkin.stocks.jooq.tables.Company.COMPANY;

@Service
@RequiredArgsConstructor
public class StocksService {

    private final IexCloudClient iexCloudClient;
    private final DSLContext dsl;

    public void updateCompanies(Set<String> symbols) {
        List<CompanyDto> companies = symbols.stream().map(iexCloudClient::getCompany).toList();
        List<Query> inserts = companies.stream().map(c -> dsl.insertInto(COMPANY, COMPANY.ID, COMPANY.INDUSTRY, COMPANY.NAME, COMPANY.SECTOR, COMPANY.SYMBOL)
                        .values(UUID.randomUUID(), c.getIndustry(), c.getCompanyName(), c.getSector(), c.getSymbol()))
                .collect(Collectors.toList());
        dsl.batch(inserts).execute();
        dsl.batchInsert();
    }
}
