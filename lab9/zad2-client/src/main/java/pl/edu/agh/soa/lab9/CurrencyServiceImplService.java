package pl.edu.agh.soa.lab9;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;

@WebServiceClient(name = "CurrencyServiceImplService", targetNamespace = "http://lab9.soa.agh.edu.pl/", wsdlLocation = "http://localhost:8080/zad2-service/CurrencyServiceImpl?wsdl")
public class CurrencyServiceImplService extends Service {

    private final static URL CURRENCY_SERVICE_IMPL_WSDL_LOCATION;
    private final static WebServiceException CURRENCY_SERVICE_IMPL_EXCEPTION;
    private final static QName CURRENCY_SERVICE_IMPL_QNAME = new QName("http://lab9.soa.agh.edu.pl/", "CurrencyServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/zad2-service/CurrencyServiceImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CURRENCY_SERVICE_IMPL_WSDL_LOCATION = url;
        CURRENCY_SERVICE_IMPL_EXCEPTION = e;
    }

    public CurrencyServiceImplService() {
        super(__getWsdlLocation(), CURRENCY_SERVICE_IMPL_QNAME);
    }

    @WebEndpoint(name = "CurrencyServiceImplPort")
    public CurrencyService getCurrencyServiceImplPort() {
        return super.getPort(new QName("http://lab9.soa.agh.edu.pl/", "CurrencyServiceImplPort"), CurrencyService.class);
    }

    private static URL __getWsdlLocation() {
        if (CURRENCY_SERVICE_IMPL_EXCEPTION != null) {
            throw CURRENCY_SERVICE_IMPL_EXCEPTION;
        }
        return CURRENCY_SERVICE_IMPL_WSDL_LOCATION;
    }

}
