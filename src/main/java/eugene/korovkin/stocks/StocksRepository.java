package eugene.korovkin.stocks;

import eugene.korovkin.stocks.model.Position;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static eugene.korovkin.stocks.jooq.Tables.COMPANY;
import static eugene.korovkin.stocks.jooq.Tables.POSITION;

@Repository
@RequiredArgsConstructor
public class StocksRepository {

    private final DSLContext dsl;

    List<Position> getPositions() {
        return dsl.select(COMPANY.SYMBOL, COMPANY.NAME, POSITION.QUANTITY).from(POSITION).join(COMPANY).on(POSITION.COMPANY_ID.eq(COMPANY.ID)).fetch().map(r -> {
            Position p = new Position();
            p.setSymbol(r.get(COMPANY.SYMBOL));
            p.setCompanyName(r.get(COMPANY.NAME));
            p.setQuantity(r.get(POSITION.QUANTITY));
            return p;
        });
    }
}
