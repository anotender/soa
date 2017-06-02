package pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.impl;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.model.Ticket;
import pl.edu.agh.soa.projekt.pas.repository.TicketRepository;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.api.ParkingPlaceSOAPService;
import pl.edu.agh.soa.projekt.pas.service.ticket.TicketService;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Transactional;
import java.util.Optional;

@WebService(endpointInterface = "pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.api.ParkingPlaceSOAPService")
public class ParkingPlaceSOAPServiceImpl implements ParkingPlaceSOAPService {

    @EJB
    private ParkingPlaceService parkingPlaceService;

    @EJB
    private TicketService ticketService;

    public void takePlace(long id) {
        changeParkingPlaceState(id, true);
    }

    public void leavePlace(long id) {
        changeParkingPlaceState(id, false);
    }

    @Transactional
    private void changeParkingPlaceState(long id, boolean occupied) {
        ParkingPlace parkingPlace = parkingPlaceService.getParkingPlace(id);
        Ticket ticket = parkingPlace.getTicket();

        parkingPlace.setOccupied(occupied);
        parkingPlace.setTicket(null);
        parkingPlaceService.updateParkingPlace(parkingPlace);

        Optional
                .ofNullable(ticket)
                .map(t -> {
                    t.setParkingPlace(null);
                    return t;
                })
                .ifPresent(ticketService::updateTicket);
    }
}
