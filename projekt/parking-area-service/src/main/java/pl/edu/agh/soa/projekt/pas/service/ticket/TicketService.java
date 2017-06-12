package pl.edu.agh.soa.projekt.pas.service.ticket;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.model.Ticket;
import pl.edu.agh.soa.projekt.pas.model.dto.TicketDTO;
import pl.edu.agh.soa.projekt.pas.repository.StreetRepository;
import pl.edu.agh.soa.projekt.pas.repository.TicketRepository;
import pl.edu.agh.soa.projekt.pas.service.detector.IllegalStateDetector;
import pl.edu.agh.soa.projekt.pas.service.detector.NotificationHandler;
import pl.edu.agh.soa.projekt.pas.util.DTOMapper;
import pl.edu.agh.soa.projekt.pas.util.TicketUtils;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

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

    @EJB
    private NotificationHandler notificationHandler;

    public TicketDTO getTicketDTO(Long id) {
        return ticketRepository
                .findOne(id)
                .map(DTOMapper::mapTicketToTicketDTO)
                .orElseThrow(RuntimeException::new);
    }

    public List<TicketDTO> getTicketDTOs() {
        return getTickets()
                .stream()
                .map(DTOMapper::mapTicketToTicketDTO)
                .collect(Collectors.toList());
    }

    public void saveTicket(TicketDTO ticketDTO) {
        saveTicket(DTOMapper.mapTicketDTOToTicket(ticketDTO));
    }

    public void updateTicket(Ticket t) {
        ticketRepository.update(t);
    }

    public Optional<Ticket> getFirstTicketToExpire() {
        return getTickets()
                .stream()
                .filter(TicketUtils::isNotExpired)
                .sorted(Comparator.comparing(Ticket::getExpirationTime))
                .findFirst();
    }

    private void saveTicket(Ticket t) {
        ticketRepository.save(t);
        bindTicketWithParkingPlace(t.getId());
        illegalStateDetector.registerTicket(t);
    }

    private List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    private void bindTicketWithParkingPlace(Long ticketId) {
        Ticket ticket = ticketRepository
                .findOne(ticketId)
                .orElseThrow(RuntimeException::new);

        Set<ParkingPlace> parkingPlaces = findPossibleParkingPlacesForTicket(ticket);

        findOccupiedParkingPlaceWithoutTicket(parkingPlaces).ifPresent(parkingPlace -> {
            ticket.setParkingPlace(parkingPlace);
            updateTicket(ticket);
            String message = "Ticket with id: " + ticketId + " has just been bound to parking place with id: " + parkingPlace.getId();
            notificationHandler.sendMessage(message);
        });
    }

    private Optional<ParkingPlace> findOccupiedParkingPlaceWithoutTicket(Set<ParkingPlace> parkingPlaces) {
        return parkingPlaces
                .stream()
                .filter(ParkingPlace::isOccupied)
                .filter(pp -> Objects.isNull(pp.getTicket()))
                .findAny();
    }

    private Set<ParkingPlace> findPossibleParkingPlacesForTicket(Ticket t) {
        return streetRepository
                .findStreetByParkingMeterId(t.getParkingMeter().getId())
                .orElseThrow(RuntimeException::new)
                .getParkingPlaces();
    }
}
