package pl.edu.agh.soa.lab3.przyklad.model;

import java.util.ArrayList;
import java.util.List;

public class EkspertPiwny {

    public static List<String> getMarki(String kolor) {
        List<String> marki = new ArrayList();

        if ("bursztynowy".equals(kolor)) {
            marki.add("Lech");
            marki.add("Zywiec");
        } else if ("jasny".equals(kolor)) {
            marki.add("Tyskie");
        } else if ("ciemny".equals(kolor)) {
            marki.add("Guines");
        } else if ("brazowy".equals(kolor)) {
            marki.add("Mocny Full");
        }

        return marki;
    }

}
