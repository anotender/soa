package pl.edu.agh.soa.lab10.zad1.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode
public class Cat {
    private String id = UUID.randomUUID().toString();
    private String name;
}
