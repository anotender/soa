package pl.edu.agh.soa.lab9;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "pl.edu.agh.soa.lab9.CurrencyService")
public class CurrencyServiceImpl implements CurrencyService {

    private static final Map<String, Double> EXCHANGE_RATE_MAP = initExchangeRateMap();

    private static Map<String, Double> initExchangeRateMap() {
        Map<String, Double> exchangeRateMap = new HashMap<>();

        exchangeRateMap.put("EUR", 4.3);
        exchangeRateMap.put("USD", 3.8);
        exchangeRateMap.put("CHF", 3.9);
        exchangeRateMap.put("GBP", 4.9);

        return exchangeRateMap;
    }

    public double getExchangeRate(String currency) {
        return EXCHANGE_RATE_MAP.getOrDefault(currency, 0.0);
    }

    public double exchange(String currency, double value) {
        return getExchangeRate(currency) * value;
    }
}
