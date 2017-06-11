package pl.edu.agh.soa.projekt.pas.controller.rest;

import pl.edu.agh.soa.projekt.pas.model.Ticket;
import pl.edu.agh.soa.projekt.pas.service.ticket.TicketService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/ticket")
public class TicketController {
    @EJB
    private TicketService ticketService;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Ticket getTicket(@PathParam("id") Long id) {
        return ticketService.getTicket(id);
    }

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    public void saveTicket(Ticket ticket) {
        ticketService.saveTicket(ticket);
    }

}
