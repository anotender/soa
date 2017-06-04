package pl.edu.agh.soa.projekt.pas.service.ticket;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.model.Ticket;
import pl.edu.agh.soa.projekt.pas.repository.StreetRepository;
import pl.edu.agh.soa.projekt.pas.repository.TicketRepository;
import pl.edu.agh.soa.projekt.pas.service.detector.IllegalStateDetector;
import pl.edu.agh.soa.projekt.pas.util.TicketUtils;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Singleton
@Startup
@Transactional
public class TicketService {
    @EJB
    private TicketRepository ticketRepository;

    @EJB
    private StreetRepository streetRepository;

    @EJB
    private IllegalStateDetector illegalStateDetector;

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public void saveTicket(Ticket t) {
        ticketRepository.save(t);
        bindTicketWithParkingPlace(t.getId());
        illegalStateDetector.registerTicket(t);
    }

    public void updateTicket(Ticket t) {
        ticketRepository.update(t);
    }

    public void deleteTicket(Ticket t) {
        ticketRepository.delete(t);
    }

    public Ticket getFirstTicketToExpire() {
        return getTickets()
                .stream()
                .filter(TicketUtils::isNotExpired)
                .sorted(Comparator.comparing(Ticket::getExpirationTime))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private void bindTicketWithParkingPlace(Long ticketId) {
        Ticket ticket = ticketRepository
                .findOne(ticketId)
                .orElseThrow(RuntimeException::new);

        List<ParkingPlace> parkingPlaces = findPossibleParkingPlacesForTicket(ticket);

        findOccupiedParkingPlaceWithoutTicket(parkingPlaces).ifPresent(parkingPlace -> {
            ticket.setParkingPlace(parkingPlace);
            updateTicket(ticket);
        });
    }

    private Optional<ParkingPlace> findOccupiedParkingPlaceWithoutTicket(List<ParkingPlace> parkingPlaces) {
        return parkingPlaces
                .stream()
                .filter(ParkingPlace::isOccupied)
                .filter(pp -> Objects.isNull(pp.getTicket()))
                .findAny();
    }

    private List<ParkingPlace> findPossibleParkingPlacesForTicket(Ticket t) {
        return streetRepository
                .findStreetByParkingMeterId(t.getParkingMeter().getId())
                .orElseThrow(RuntimeException::new)
                .getParkingPlaces();
    }
}
