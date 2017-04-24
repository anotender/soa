package pl.edu.agh.soa.lab6.zad3;

import javax.ejb.Stateless;

@Stateless
public class ConverterImpl implements Converter {
    public double fahr2Cels(double temp) {
        return (5 * (temp - 32)) / 9;
    }

    public double cels2Fahr(double temp) {
        return (9 * temp) / 5 + 32;
    }
}
