package pl.edu.agh.soa.projekt.pas.controller.rest;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/parkingplace")
public class ParkingPlaceController {
    @EJB
    private ParkingPlaceService parkingPlaceService;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public ParkingPlace getParkingPlace(@PathParam("id") Long id) {
        return parkingPlaceService.getParkingPlace(id);
    }

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public List<ParkingPlace> getParkingPlaces() {
        return parkingPlaceService.getParkingPlaces();
    }
}
