package eugene.korovkin.stocks.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {

    private String symbol;
    private String companyName;
    private int quantity;
}
