package pl.edu.agh.soa.lab3.zad1.util;

import java.util.ResourceBundle;

public class CurrencyConverter {
    public static double convert(String fromCurrency, String toCurrency, double amount) {
        ResourceBundle currencies = ResourceBundle.getBundle("currencies");
        double from = Double.parseDouble(currencies.getString(fromCurrency));
        double to = Double.parseDouble(currencies.getString(toCurrency));
        return Math.round(amount * from * to * 100.0) / 100.0;
    }
}
