package pl.edu.agh.soa.lab9;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import static javax.jws.soap.SOAPBinding.Style.RPC;

@WebService
@SOAPBinding(style = RPC)
public interface CurrencyService {
    @WebMethod
    double getExchangeRate(String currency);

    @WebMethod
    double exchange(String currency, double value);
}
