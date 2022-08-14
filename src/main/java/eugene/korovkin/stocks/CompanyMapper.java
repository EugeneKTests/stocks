package eugene.korovkin.stocks;

import eugene.korovkin.stocks.iex.dto.CompanyDto;
import eugene.korovkin.stocks.jooq.tables.records.CompanyRecord;

public class CompanyMapper {

    public static CompanyDto dtoToRecord(CompanyRecord record) {
        CompanyDto dto = new CompanyDto();
        dto.setId(record.getId());
        dto.setSymbol(record.getSymbol());
        dto.setSector(record.getSector());
        dto.setCompanyName(record.getName());
        dto.setIndustry(record.getIndustry());
        return dto;
    }
}
