package pl.edu.agh.soa.projekt.pas.controller.rest;

import pl.edu.agh.soa.projekt.pas.model.dto.TicketDTO;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;
import pl.edu.agh.soa.projekt.pas.service.ticket.TicketService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/ticket")
public class TicketController {
    @EJB
    private TicketService ticketService;

    @EJB
    private ParkingPlaceService parkingPlaceService;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getTicket(@PathParam("id") Long id) {
        return Response.ok(ticketService.getTicketDTO(id)).build();
    }

    @GET
    @Path("/{id}/parkingplace")
    @Produces(APPLICATION_JSON)
    public Response getParkingPlaceForTicket(@PathParam("id") Long id) {
        return Response.ok(parkingPlaceService.getParkingPlaceDTOForTicket(id)).build();
    }

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public List<TicketDTO> getTickets() {
        return ticketService.getTicketDTOs();
    }

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    public Response saveTicket(TicketDTO ticketDTO) {
        ticketService.saveTicket(ticketDTO);
        return Response.status(Response.Status.CREATED).build();
    }

}
