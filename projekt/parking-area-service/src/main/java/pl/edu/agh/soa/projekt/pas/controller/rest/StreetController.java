package pl.edu.agh.soa.projekt.pas.controller.rest;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.model.Street;
import pl.edu.agh.soa.projekt.pas.service.street.StreetService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/street")
public class StreetController {
    @EJB
    private StreetService streetService;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Street getStreet(@PathParam("id") Long id) {
        return streetService.getStreet(id);
    }

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public List<Street> getStreets() {
        return streetService.getStreets();
    }

    @GET
    @Path("/{id}/parkingplace")
    @Produces(APPLICATION_JSON)
    public List<ParkingPlace> getParkingPlacesForStreet(@PathParam("id") Long id) {
        return streetService.getStreet(id).getParkingPlaces();
    }
}
