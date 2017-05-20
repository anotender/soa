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
        Session session = getSessionAndBeginTransaction();

        List<Book> books = (List<Book>) session
                .createQuery("from pl.edu.agh.soa.lab8.zad3.model.Book")
                .list();

        commitTransactionAndCloseSession(session);
        return books;
    }

    public Optional<Book> findOne(long id) {
        Session session = getSessionAndBeginTransaction();

        Object result = session
                .createQuery("" +
                        "from pl.edu.agh.soa.lab8.zad3.model.Book as b " +
                        "where b.id = " + id
                )
                .uniqueResult();

        commitTransactionAndCloseSession(session);

        if (Objects.isNull(result)) {
            return Optional.empty();
        }
        return Optional.of((Book) result);
    }

    public void save(Book b) {
        Session session = getSessionAndBeginTransaction();

        session.save(b);

        commitTransactionAndCloseSession(session);
    }

    public void update(long id, Book newBook) {
        findOne(id).ifPresent(oldBook -> {
            Session session = getSessionAndBeginTransaction();

            newBook.setId(oldBook.getId());
            session.update(newBook);

            commitTransactionAndCloseSession(session);

        });
    }

    public void delete(long id) {
        findOne(id).ifPresent(b -> {
            Session session = getSessionAndBeginTransaction();

            session.delete(b);

            commitTransactionAndCloseSession(session);
        });
    }

    private Session getSessionAndBeginTransaction() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    private void commitTransactionAndCloseSession(Session session) {
        session.getTransaction().commit();
        session.close();
    }
}
