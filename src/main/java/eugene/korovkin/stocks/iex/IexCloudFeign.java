package eugene.korovkin.stocks.iex;

import eugene.korovkin.stocks.iex.dto.CompanyDtoIex;
import eugene.korovkin.stocks.iex.dto.DividendsDtoIex;
import eugene.korovkin.stocks.iex.dto.PreviousDtoIex;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "iexCloud", url = "${params.iex-cloud-url}")
public interface IexCloudFeign {

    @GetMapping("stock/{symbol}/company")
    CompanyDtoIex getCompany(@PathVariable("symbol") String symbol, @RequestParam("token") String token);

    @GetMapping("stock/{symbol}/previous")
    PreviousDtoIex getPrevious(@PathVariable("symbol") String symbol, @RequestParam("token") String token);

    @GetMapping("stock/{symbol}/dividends/{range}")
    List<DividendsDtoIex> getNextDividents(@PathVariable("symbol") String symbol, @PathVariable("range") String range,
                                           @RequestParam("token") String token);
}
