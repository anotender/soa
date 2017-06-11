package pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.impl;

import pl.edu.agh.soa.projekt.pas.model.HistoricEvent;
import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.model.Ticket;
import pl.edu.agh.soa.projekt.pas.service.detector.IllegalStateDetector;
import pl.edu.agh.soa.projekt.pas.service.detector.NotificationHandler;
import pl.edu.agh.soa.projekt.pas.service.historicevent.HistoricEventService;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.api.ParkingPlaceSOAPService;
import pl.edu.agh.soa.projekt.pas.service.ticket.TicketService;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Transactional;
import java.util.Objects;

@WebService(endpointInterface = "pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.api.ParkingPlaceSOAPService")
public class ParkingPlaceSOAPServiceImpl implements ParkingPlaceSOAPService {

    @EJB
    private ParkingPlaceService parkingPlaceService;

    @EJB
    private TicketService ticketService;

    @EJB
    private HistoricEventService historicEventService;

    @EJB
    private NotificationHandler notificationHandler;

    @EJB
    private IllegalStateDetector illegalStateDetector;

    public void takePlace(long id) {
        changeParkingPlaceState(id, true);
        notificationHandler.sendMessage("Parking place with id: " + id + " has just been taken");
    }

    public void leavePlace(long id) {
        changeParkingPlaceState(id, false);
        notificationHandler.sendMessage("Parking place with id: " + id + " has just been left");
    }

    @Transactional
    private void changeParkingPlaceState(long id, boolean occupied) {
        ParkingPlace parkingPlace = parkingPlaceService.getParkingPlace(id);

        //You cannot take taken place or leave empty place
        if (parkingPlace.isOccupied() == occupied) {
            return;
        }

        Ticket ticket = parkingPlace.getTicket();

        if (!occupied) {
            HistoricEvent historicEvent = new HistoricEvent();
            historicEvent.setParkingPlace(parkingPlace);
            historicEvent.setTicket(ticket);
            historicEventService.saveHistoricEvent(historicEvent);
        }

        parkingPlace.setOccupied(occupied);
        parkingPlace.setTicket(null);
        parkingPlaceService.updateParkingPlace(parkingPlace);

        if (Objects.nonNull(ticket)) {
            ticket.setParkingPlace(null);
            ticketService.updateTicket(ticket);
            illegalStateDetector.unregisterTicket(ticket);
        }
    }
}
