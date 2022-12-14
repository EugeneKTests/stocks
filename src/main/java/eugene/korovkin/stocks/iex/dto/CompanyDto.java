package eugene.korovkin.stocks.iex.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CompanyDto {

    private UUID id;
    private String symbol;
    private String sector;
    private String companyName;
    private String industry;
}