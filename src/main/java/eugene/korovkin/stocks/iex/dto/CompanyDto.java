package eugene.korovkin.stocks.iex.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {

    private String symbol;
    private String sector;
    private String companyName;
    private String industry;
}