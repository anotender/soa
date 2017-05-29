package pl.edu.agh.soa.lab9;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "CurrencyService", targetNamespace = "http://lab9.soa.agh.edu.pl/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CurrencyService {

    @WebMethod
    @WebResult(partName = "return")
    double exchange(
            @WebParam(name = "arg0", partName = "arg0") String arg0,
            @WebParam(name = "arg1", partName = "arg1") double arg1
    );

    @WebMethod
    @WebResult(partName = "return")
    double getExchangeRate(@WebParam(name = "arg0", partName = "arg0") String arg0);

}
