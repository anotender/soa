package pl.edu.agh.soa.lab10.zad2.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/art")
public class ArtController {

    @GET
    @Path("/")
    public Response redirect() throws URISyntaxException {
        return Response.temporaryRedirect(new URI("/movies")).build();
    }

}
