package eugene.korovkin.stocks.iex.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class DividendsDtoIex {

    private BigDecimal amount;
    private LocalDate paymentDate;
}
