package pl.edu.agh.soa.lab4.zad4.model;

import lombok.Data;

import javax.faces.bean.ManagedBean;

@Data
@ManagedBean
public class MaleModel {
    private int klatka;
    private int pas;
    private int dlugoscNogi;
}
