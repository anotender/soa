package pl.edu.agh.soa.projekt.pas.repository;

import pl.edu.agh.soa.projekt.pas.model.Street;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Singleton
@Startup
public class StreetRepository {
    @PersistenceContext(unitName = "projekt-pu")
    private EntityManager em;

    public Optional<Street> findOne(Long id) {
        return Optional.ofNullable(em.find(Street.class, id));
    }

    public Optional<Street> findStreetByParkingMeterId(Long parkingMeterId) {
        try {
            Object result = em
                    .createQuery("" +
                            "select p.street " +
                            "from ParkingMeter p " +
                            "where p.id = :parkingMeterId"
                    )
                    .setParameter("parkingMeterId", parkingMeterId)
                    .getSingleResult();
            return Optional.of((Street) result);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public List<Street> findAll() {
        return (List<Street>) em
                .createQuery("from Street")
                .getResultList();
    }

    public List<Street> findByAreaId(Long id) {
        return (List<Street>) em
                .createQuery("" +
                        "select a.streets " +
                        "from Area a " +
                        "where a.id = :areaId"
                )
                .setParameter("areaId", id)
                .getResultList();
    }
}
