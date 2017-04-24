package pl.edu.agh.soa.lab6.zad3;

import javax.ejb.Remote;

@Remote
public interface Converter {

    double fahr2Cels(double temp);

    double cels2Fahr(double temp);

}
