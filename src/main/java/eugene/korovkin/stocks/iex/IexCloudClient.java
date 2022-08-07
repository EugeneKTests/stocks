package eugene.korovkin.stocks.iex;

import eugene.korovkin.stocks.iex.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IexCloudClient {

    @Value("${params.token}")
    private String token;

    private final IexCloudFeign iexCloudFeign;

    public CompanyDto getCompany(String symbol) {
        return iexCloudFeign.getCompany(symbol, token);
    }

}
