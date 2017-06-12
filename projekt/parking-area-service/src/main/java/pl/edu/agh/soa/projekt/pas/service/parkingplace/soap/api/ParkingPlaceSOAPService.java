package pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.api;

import pl.edu.agh.soa.projekt.pas.model.dto.ParkingPlaceDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

import static javax.jws.soap.SOAPBinding.Style.RPC;

@WebService
@SOAPBinding(style = RPC)
public interface ParkingPlaceSOAPService {

    @WebMethod
    void takePlace(long id);

    @WebMethod
    void leavePlace(long id);

    @WebMethod
    List<ParkingPlaceDTO> getParkingPlaces();

    @WebMethod
    List<ParkingPlaceDTO> getParkingPlacesForStreet(long id);

    @WebMethod
    List<ParkingPlaceDTO> getParkingPlacesForArea(long id);
}
