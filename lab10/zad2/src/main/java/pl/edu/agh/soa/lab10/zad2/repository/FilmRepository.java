package pl.edu.agh.soa.lab10.zad2.repository;

import pl.edu.agh.soa.lab10.zad2.model.Film;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
@Startup
public class FilmRepository {
    private List<Film> films;

    public FilmRepository() {
        films = new LinkedList<>();
        films.add(new Film("Film1"));
        films.add(new Film("Film2"));
        films.add(new Film("Film3"));
    }

    public Optional<Film> findOne(String id) {
        return films
                .stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();
    }

    public List<Film> findAll() {
        return films;
    }

    public List<Film> findByTitle(String title) {
        return films
                .stream()
                .filter(f -> f.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public void remove(String id) {
        findOne(id).ifPresent(films::remove);
    }
}
