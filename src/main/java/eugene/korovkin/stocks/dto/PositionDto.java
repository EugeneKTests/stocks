package eugene.korovkin.stocks.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PositionDto {

    private String symbol;
    private String companyName;
    private int quantity;
    private BigDecimal currentPrice;
    private BigDecimal totalPrice;
}
