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

    public List<Street> findAll() {
        return (List<Street>) em
                .createQuery("from Street")
                .getResultList();
    }

    // TODO: 6/3/17 change it to hql query
    public Optional<Street> findStreetByParkingMeterId(Long parkingMeterId) {
        return findAll()
                .stream()
                .filter(s -> s
                        .getParkingMeters()
                        .stream()
                        .anyMatch(p -> p.getId().equals(parkingMeterId))
                )
                .findFirst();
    }
}
