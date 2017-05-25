package pl.edu.agh.soa.projekt.pas.service.soap.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(
        name = "ParkingPlaceService",
        targetNamespace = "http://api.soap.service.pas.projekt.soa.agh.edu.pl/"
)
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ParkingPlaceService {
    @WebMethod
    void leavePlace(@WebParam(name = "id", partName = "id") long id);

    @WebMethod
    void takePlace(@WebParam(name = "id", partName = "id") long id);
}
