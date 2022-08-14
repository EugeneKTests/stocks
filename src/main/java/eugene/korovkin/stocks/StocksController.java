package eugene.korovkin.stocks;

import eugene.korovkin.stocks.dto.DividendsRowDto;
import eugene.korovkin.stocks.dto.Portfolio;
import eugene.korovkin.stocks.iex.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/stocks")
@RestController
@RequiredArgsConstructor
public class StocksController {

    private final StocksService stocksService;

    @PostMapping("update")
    public void updateStocks(@RequestBody Set<String> symbols) {
        stocksService.updateCompanies(symbols);
    }

    @GetMapping
    public List<CompanyDto> getCompanies() {
        return stocksService.getCompanies();
    }

    @GetMapping("portfolio")
    public Portfolio getPortfolio() {
        return stocksService.getPortfolio();
    }

    @GetMapping("dividends")
    public List<DividendsRowDto> getdDividends() {
        return stocksService.getDividends();
    }
}
