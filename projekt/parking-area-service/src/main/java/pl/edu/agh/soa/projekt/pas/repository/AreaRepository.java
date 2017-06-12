package pl.edu.agh.soa.projekt.pas.repository;

import pl.edu.agh.soa.projekt.pas.model.Area;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Singleton
@Startup
public class AreaRepository {

    @PersistenceContext(unitName = "projekt-pu")
    private EntityManager em;

    public Optional<Area> findOne(Long id) {
        return Optional.ofNullable(em.find(Area.class, id));
    }

    public Optional<Area> findOneByStreetId(Long id) {
        try {
            Object result = em
                    .createQuery("" +
                            "select s.area " +
                            "from Street s " +
                            "where s.id = :streetId"
                    )
                    .setParameter("streetId", id)
                    .getSingleResult();
            return Optional.of((Area) result);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public List<Area> findAll() {
        return (List<Area>) em
                .createQuery("from Area")
                .getResultList();
    }
}
