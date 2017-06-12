package pl.edu.agh.soa.projekt.pas.util;

import pl.edu.agh.soa.projekt.pas.model.*;
import pl.edu.agh.soa.projekt.pas.model.dto.AreaDTO;
import pl.edu.agh.soa.projekt.pas.model.dto.ParkingPlaceDTO;
import pl.edu.agh.soa.projekt.pas.model.dto.StreetDTO;
import pl.edu.agh.soa.projekt.pas.model.dto.TicketDTO;

import java.util.Objects;

public class DTOMapper {

    public static ParkingPlaceDTO mapParkingPlaceToParkingPlaceDTO(ParkingPlace parkingPlace) {
        ParkingPlaceDTO parkingPlaceDTO = new ParkingPlaceDTO();

        parkingPlaceDTO.setId(parkingPlace.getId());
        parkingPlaceDTO.setOccupied(parkingPlace.isOccupied());

        return parkingPlaceDTO;
    }

    public static StreetDTO mapStreetToStreetDTO(Street street) {
        StreetDTO streetDTO = new StreetDTO();

        streetDTO.setId(street.getId());
        streetDTO.setName(street.getName());

        return streetDTO;
    }

    public static AreaDTO mapAreaToAreaDTO(Area area) {
        AreaDTO areaDTO = new AreaDTO();

        areaDTO.setId(area.getId());
        areaDTO.setName(area.getName());

        return areaDTO;
    }

    public static TicketDTO mapTicketToTicketDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.setId(ticket.getId());
        ticketDTO.setExpirationTime(ticket.getExpirationTime());
        ticketDTO.setDuration(ticket.getDuration());
        ticketDTO.setParkingPlaceId(ticket.getParkingPlace().getId());
        ticketDTO.setParkingMeterId(ticket.getParkingMeter().getId());

        return ticketDTO;
    }

    public static Ticket mapTicketDTOToTicket(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();

        ticket.setId(ticketDTO.getId());
        ticket.setExpirationTime(ticketDTO.getExpirationTime());
        ticket.setDuration(ticketDTO.getDuration());

        ParkingPlace parkingPlace = null;
        if (Objects.nonNull(ticketDTO.getParkingPlaceId())) {
            parkingPlace = new ParkingPlace();
            parkingPlace.setId(ticketDTO.getParkingPlaceId());
        }
        ticket.setParkingPlace(parkingPlace);

        ParkingMeter parkingMeter = null;
        if (Objects.nonNull(ticketDTO.getParkingMeterId())) {
            parkingMeter = new ParkingMeter();
            parkingMeter.setId(ticketDTO.getParkingMeterId());
        }
        ticket.setParkingMeter(parkingMeter);

        return ticket;
    }
}
