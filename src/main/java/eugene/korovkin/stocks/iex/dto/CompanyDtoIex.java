package eugene.korovkin.stocks.iex.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDtoIex {

    private String symbol;
    private String sector;
    private String companyName;
    private String industry;
}