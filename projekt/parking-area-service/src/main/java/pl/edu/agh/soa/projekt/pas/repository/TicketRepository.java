package pl.edu.agh.soa.projekt.pas.repository;

import pl.edu.agh.soa.projekt.pas.model.Ticket;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
@Startup
@Transactional
public class TicketRepository {
    @PersistenceContext(unitName = "projekt-pu")
    private EntityManager em;

    public Optional<Ticket> findOne(Long id) {
        return Optional.ofNullable(em.find(Ticket.class, id));
    }

    public List<Ticket> findAll() {
        return (List<Ticket>) em
                .createQuery("from Ticket")
                .getResultList();
    }

    public void save(Ticket ticket) {
        em.persist(ticket);
    }

    public void update(long id, Ticket newTicket) {
        findOne(id).ifPresent(oldTicket -> {
            newTicket.setId(oldTicket.getId());
            em.merge(newTicket);
        });
    }
}
