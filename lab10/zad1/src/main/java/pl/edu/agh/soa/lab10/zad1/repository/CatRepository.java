package pl.edu.agh.soa.lab10.zad1.repository;

import pl.edu.agh.soa.lab10.zad1.model.Cat;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Singleton
@Startup
public class CatRepository {
    private final List<Cat> cats = new LinkedList<>();

    public List<Cat> findAll() {
        Cat c = new Cat();
        c.setName("name");
        cats.add(c);
        return cats;
    }

    public Optional<Cat> findOne(String id) {
        return cats
                .stream()
                .filter(cat -> cat.getId().equals(id))
                .findFirst();
    }

    public void save(List<Cat> newCats) {
        cats.addAll(newCats);
    }

    public void remove(String id) {
        Cat cat = findOne(id).orElseThrow(RuntimeException::new);
        cats.remove(cat);
    }

}
