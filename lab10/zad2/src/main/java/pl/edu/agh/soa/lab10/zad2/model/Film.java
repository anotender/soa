package pl.edu.agh.soa.lab10.zad2.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Film {
    private String id = UUID.randomUUID().toString();
    private String title;
}
