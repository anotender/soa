package pl.edu.agh.soa.lab4.zad4.model;

import lombok.Data;

import javax.faces.bean.ManagedBean;

@Data
@ManagedBean
public class FemaleModel {
    private int obwodBiustu;
    private String wielkoscMiseczki;
    private int talia;
    private int biodra;
    private int dlugoscNogi;
}
