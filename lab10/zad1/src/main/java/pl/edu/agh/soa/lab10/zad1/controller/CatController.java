package pl.edu.agh.soa.lab10.zad1.controller;

import pl.edu.agh.soa.lab10.zad1.model.Cat;
import pl.edu.agh.soa.lab10.zad1.repository.CatRepository;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/cats")
public class CatController {
    @EJB
    private CatRepository catRepository;

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public List<Cat> getCats() {
        return catRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getCat(@PathParam("id") String id) {
        return catRepository
                .findOne(id)
                .map(cat1 -> Response.ok(cat1).build())
                .orElseGet(() -> Response.status(NOT_FOUND).build());
    }

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    public Response saveCats(List<Cat> cats) {
        catRepository.save(cats);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    public Response updateCat(@PathParam("id") String id, Cat cat) {
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeCat(@PathParam("id") String id) {
        try {
            catRepository.remove(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(NOT_FOUND).build();
        }
    }
}
