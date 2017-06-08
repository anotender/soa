package pl.edu.agh.soa.projekt.pas.repository;

import pl.edu.agh.soa.projekt.pas.model.HistoricEvent;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
@Startup
public class HistoricEventRepository {
    @PersistenceContext(unitName = "projekt-pu")
    private EntityManager em;

    public List<HistoricEvent> findAll() {
        return (List<HistoricEvent>) em
                .createQuery("from HistoricEvent")
                .getResultList();
    }

    public void save(HistoricEvent he) {
        em.persist(he);
    }
}
