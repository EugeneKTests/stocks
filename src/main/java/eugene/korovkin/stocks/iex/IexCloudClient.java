package eugene.korovkin.stocks.iex;

import eugene.korovkin.stocks.iex.dto.CompanyDtoIex;
import eugene.korovkin.stocks.iex.dto.DividendsDtoIex;
import eugene.korovkin.stocks.iex.dto.PreviousDtoIex;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IexCloudClient {

    @Value("${params.token}")
    private String token;

    private final IexCloudFeign iexCloudFeign;

    public CompanyDtoIex getCompany(String symbol) {
        return iexCloudFeign.getCompany(symbol, token);
    }

    public PreviousDtoIex getPrevious(String symbol) {
        return iexCloudFeign.getPrevious(symbol, token);
    }

    public DividendsDtoIex getNextDividends(String symbol) {
        List<DividendsDtoIex> dividendsList = iexCloudFeign.getNextDividents(symbol, "", token);
        if (CollectionUtils.isEmpty(dividendsList)) {
            return null;
        }
        return dividendsList.get(0);
    }

}
