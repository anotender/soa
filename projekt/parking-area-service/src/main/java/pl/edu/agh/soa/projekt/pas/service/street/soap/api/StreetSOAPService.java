package pl.edu.agh.soa.projekt.pas.service.street.soap.api;

import pl.edu.agh.soa.projekt.pas.model.dto.StreetDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

import static javax.jws.soap.SOAPBinding.Style.RPC;

@WebService
@SOAPBinding(style = RPC)
public interface StreetSOAPService {
    @WebMethod
    List<StreetDTO> getStreets();

    @WebMethod
    long countOccupiedPlacesOnStreet(long id);

    @WebMethod
    long countFreePlacesOnStreet(long id);
}
