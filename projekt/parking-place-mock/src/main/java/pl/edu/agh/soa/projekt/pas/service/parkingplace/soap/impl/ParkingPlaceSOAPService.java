package pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(
        name = "ParkingPlaceSOAPService",
        targetNamespace = "http://api.soap.parkingplace.service.pas.projekt.soa.agh.edu.pl/"
)
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ParkingPlaceSOAPService {

    @WebMethod
    void takePlace(@WebParam(name = "arg0", partName = "arg0") long arg0);

    @WebMethod
    void leavePlace(@WebParam(name = "arg0", partName = "arg0") long arg0);

}
