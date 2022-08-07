package eugene.korovkin.stocks.iex;

import eugene.korovkin.stocks.iex.dto.CompanyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "iexCloud", url = "${params.iex-cloud-url}")
public interface IexCloudFeign {

    @GetMapping("stock/{symbol}/company")
    public CompanyDto getCompany(@PathVariable("symbol") String symbol, @RequestParam("token") String token);

}
