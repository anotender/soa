package pl.edu.agh.soa.projekt.pas.service.ticket;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.model.Ticket;
import pl.edu.agh.soa.projekt.pas.repository.TicketRepository;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Singleton
@Startup
@Transactional
public class TicketService {
    @EJB
    private TicketRepository ticketRepository;

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public void saveTicket(Ticket t) {
        ticketRepository.save(t);
    }

    public void updateTicket(Ticket t) {
        ticketRepository.update(t);
    }

    public void deleteTicket(Ticket t) {
        ticketRepository.delete(t);
    }

    public void bindTicketWithParkingPlace(Long ticketId) {
        Ticket ticket = ticketRepository
                .findOne(ticketId)
                .orElseThrow(() -> new RuntimeException("Something went wrong..."));

        List<ParkingPlace> parkingPlaces = ticket
                .getParkingMeter()
                .getStreet()
                .getParkingPlaces();

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

}
