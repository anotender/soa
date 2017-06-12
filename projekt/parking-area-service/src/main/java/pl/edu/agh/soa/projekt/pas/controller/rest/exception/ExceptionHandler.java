package pl.edu.agh.soa.projekt.pas.controller.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {
    public Response toResponse(Exception exception) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
