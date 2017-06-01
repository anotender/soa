package pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.api;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import static javax.jws.soap.SOAPBinding.Style.RPC;

@WebService
@SOAPBinding(style = RPC)
public interface ParkingPlaceSOAPService {

    @WebMethod
    void takePlace(long id);

    @WebMethod
    void leavePlace(long id);

}
