package pl.edu.agh.soa.lab8.zad3.repository;

import pl.edu.agh.soa.lab8.zad3.model.Book;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Singleton
@Startup
public class BookRepository {

    @PersistenceContext(name = "books-pu")
    private EntityManager em;

    public List<Book> findAll() {
        return (List<Book>) em
                .createQuery("from pl.edu.agh.soa.lab8.zad3.model.Book")
                .getResultList();
    }

    public Optional<Book> findOne(long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    public void save(Book b) {
        em.persist(b);
    }

    public void update(long id, Book newBook) {
        findOne(id).ifPresent(oldBook -> {
            newBook.setId(oldBook.getId());
            em.merge(newBook);
        });
    }

    public void delete(long id) {
        findOne(id).ifPresent(em::remove);
    }
}
