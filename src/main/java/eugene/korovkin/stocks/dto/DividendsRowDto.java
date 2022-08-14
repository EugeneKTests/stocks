package eugene.korovkin.stocks.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class DividendsRowDto {

    private String symbol;
    private String companyName;
    private int quantity;
    private BigDecimal nextDividend;
    private BigDecimal total;
    private LocalDate paymentDate;
}
