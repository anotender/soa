package pl.edu.agh.soa.projekt.pas.repository;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Singleton
@Startup
public class ParkingPlaceRepository {

    @PersistenceContext(unitName = "projekt-pu")
    private EntityManager em;

    public List<ParkingPlace> findAll() {
        return (List<ParkingPlace>) em
                .createQuery("from ParkingPlace order by id")
                .getResultList();
    }

    public Optional<ParkingPlace> findOne(long id) {
        return Optional.ofNullable(em.find(ParkingPlace.class, id));
    }

    public void update(ParkingPlace p) {
        em.merge(p);
    }
}
