package pl.edu.agh.soa.lab4.zad4.model;

import lombok.Data;

import javax.faces.bean.ManagedBean;

@Data
@ManagedBean
public class Model {
    private String imie;
    private String nazwisko;
    private String adres;
    private String telefon;
    private String email;
    private int wiek;
    private int wzrost;
    private int waga;
    private String kolorWlosow;
    private String kolorOczu;
    private String rozmiarUbrania;
    private int numerButow;
    private int doswiadczenie;
    private String plec;
}
