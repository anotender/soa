package pl.edu.agh.soa.lab10.zad2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Film {
    private String id = UUID.randomUUID().toString();
    private String title;
    private String uri = "http://localhost:8080/zad2/rest/movies/" + id;

    public Film(String title) {
        this.title = title;
    }
}
