package pl.edu.agh.soa.projekt.pas.controller.rest;

import pl.edu.agh.soa.projekt.pas.model.dto.AreaDTO;
import pl.edu.agh.soa.projekt.pas.model.dto.ParkingPlaceDTO;
import pl.edu.agh.soa.projekt.pas.model.dto.StreetDTO;
import pl.edu.agh.soa.projekt.pas.service.area.AreaService;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;
import pl.edu.agh.soa.projekt.pas.service.street.StreetService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/area")
public class AreaController {

    @EJB
    private AreaService areaService;

    @EJB
    private StreetService streetService;

    @EJB
    private ParkingPlaceService parkingPlaceService;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getArea(@PathParam("id") Long id) {
        return Response.ok(areaService.getAreaDTO(id)).build();
    }

    @GET
    @Path("/{id}/street")
    @Produces(APPLICATION_JSON)
    public List<StreetDTO> getStreetsForArea(@PathParam("id") Long id) {
        return streetService.getStreetDTOsForArea(id);
    }

    @GET
    @Path("/{id}/parkingplace")
    @Produces(APPLICATION_JSON)
    public List<ParkingPlaceDTO> getParkingPlacesForArea(@PathParam("id") Long id) {
        return parkingPlaceService.getParkingPlaceDTOsForArea(id);
    }

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public List<AreaDTO> getAreas() {
        return areaService.getAreaDTOs();
    }

}
