package eugene.korovkin.stocks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
