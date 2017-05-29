package pl.edu.agh.soa.lab9;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "DayCounterService", targetNamespace = "http://lab9.soa.agh.edu.pl/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface DayCounterService {

    @WebMethod
    @WebResult(partName = "return")
    long countDays();

}
