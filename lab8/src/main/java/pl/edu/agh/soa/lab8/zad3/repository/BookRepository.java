package pl.edu.agh.soa.lab8.zad3.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.edu.agh.soa.lab8.zad3.model.Book;
import pl.edu.agh.soa.lab8.zad3.util.HibernateUtil;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Singleton
@Startup
public class BookRepository {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<Book> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Book> books = (List<Book>) session
                .createQuery("from pl.edu.agh.soa.lab8.zad3.model.Book")
                .list();

        session.getTransaction().commit();
        session.close();
        return books;
    }

    public Optional<Book> findOne(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Object result = session
                .createQuery("" +
                        "from pl.edu.agh.soa.lab8.zad3.model.Book as b " +
                        "where b.id = " + id
                )
                .uniqueResult();

        session.getTransaction().commit();
        session.close();

        if (Objects.isNull(result)) {
            return Optional.empty();
        }
        return Optional.of((Book) result);
    }

    public void save(Book b) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(b);

        session.getTransaction().commit();
        session.close();
    }

    public void update(long id, Book b) {
        throw new UnsupportedOperationException();
    }

    public void delete(long id) {
        findOne(id).ifPresent(b -> {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.delete(b);

            session.getTransaction().commit();
            session.close();
        });
    }
}
