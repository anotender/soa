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

    public Optional<ParkingPlace> findOneByTicketId(Long id) {
        try {
            Object result = em
                    .createQuery("" +
                            "select t.parkingPlace " +
                            "from Ticket t " +
                            "where t.id = :ticketId"
                    )
                    .setParameter("ticketId", id)
                    .getSingleResult();
            return Optional.of((ParkingPlace) result);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void update(ParkingPlace p) {
        em.merge(p);
    }

    public List<ParkingPlace> findByStreetId(long id) {
        return (List<ParkingPlace>) em
                .createQuery("" +
                        "select s.parkingPlaces " +
                        "from Street s " +
                        "where s.id = :streetId"
                )
                .setParameter("streetId", id)
                .getResultList();
    }

    public List<ParkingPlace> findByAreaId(Long id) {
        return (List<ParkingPlace>) em
                .createQuery("" +
                        "select s.parkingPlaces " +
                        "from Street s " +
                        "where s.area.id = :areaId"
                )
                .setParameter("areaId", id)
                .getResultList();
    }
}
