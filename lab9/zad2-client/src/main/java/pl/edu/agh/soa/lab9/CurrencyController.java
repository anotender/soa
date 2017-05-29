package pl.edu.agh.soa.lab9;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CurrencyController {
    private CurrencyService currencyService = getCurrencyService();
    private String currency;
    private double value;
    private double result;

    public void checkCurrencyExchangeRate() {
        result = currencyService.getExchangeRate(currency);
    }

    public void getExchange() {
        result = currencyService.exchange(currency, value);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    private CurrencyService getCurrencyService() {
        return new CurrencyServiceImplService().getCurrencyServiceImplPort();
    }
}
