package eugene.korovkin.stocks.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Portfolio {

    private List<PositionDto> positions;
    private BigDecimal totalPrice;
}
