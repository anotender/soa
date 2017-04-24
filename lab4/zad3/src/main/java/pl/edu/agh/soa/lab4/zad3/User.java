package pl.edu.agh.soa.lab4.zad3;

import lombok.Data;

import javax.faces.bean.ManagedBean;

@Data
@ManagedBean
public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String sex;
    private String voivodeship;
}
