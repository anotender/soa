package pl.edu.agh.soa.lab10.zad2.controller;

import pl.edu.agh.soa.lab10.zad2.repository.FilmRepository;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/movies")
public class FilmController {

    @EJB
    private FilmRepository filmRepository;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getFilm(@PathParam("id") String id) {
        return filmRepository
                .findOne(id)
                .map(f -> Response.ok(f).build())
                .orElseGet(() -> Response.status(NOT_FOUND).build());
    }

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public Response getFilms(@QueryParam("title") String title) {
        return Optional
                .ofNullable(title)
                .map(t -> Response.ok(filmRepository.findByTitle(t)).build())
                .orElseGet(() -> Response.ok(filmRepository.findAll()).build());
    }

    @DELETE
    @Path("/{id}")
    public void removeFilm(@PathParam("id") String id) {
        filmRepository.remove(id);
    }
}
