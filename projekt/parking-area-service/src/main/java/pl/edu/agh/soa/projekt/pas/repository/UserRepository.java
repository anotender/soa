package pl.edu.agh.soa.projekt.pas.repository;

import pl.edu.agh.soa.projekt.pas.model.User;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Singleton
@Startup
public class UserRepository {
    @PersistenceContext(unitName = "projekt-pu")
    private EntityManager em;

    public Optional<User> findOneByUsername(String username) {
        try {
            Object result = em
                    .createQuery("from User u where u.username like :username ")
                    .setParameter("username", username)
                    .getSingleResult();
            return Optional.of((User) result);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void update(User u) {
        em.merge(u);
    }
}
