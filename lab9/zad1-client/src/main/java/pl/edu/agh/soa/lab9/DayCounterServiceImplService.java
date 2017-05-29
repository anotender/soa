package pl.edu.agh.soa.lab9;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "DayCounterServiceImplService", targetNamespace = "http://lab9.soa.agh.edu.pl/", wsdlLocation = "http://localhost:8080/zad1-service-1.0-SNAPSHOT/DayCounterServiceImpl?wsdl")
public class DayCounterServiceImplService extends Service {

    private final static URL DAY_COUNTER_SERVICE_IMPL_WSDL_LOCATION;
    private final static WebServiceException DAY_COUNTER_SERVICE_IMPL_EXCEPTION;
    private final static QName DAY_COUNTER_SERVICE_IMPL_QNAME = new QName("http://lab9.soa.agh.edu.pl/", "DayCounterServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/zad1-service-1.0-SNAPSHOT/DayCounterServiceImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DAY_COUNTER_SERVICE_IMPL_WSDL_LOCATION = url;
        DAY_COUNTER_SERVICE_IMPL_EXCEPTION = e;
    }

    public DayCounterServiceImplService() {
        super(__getWsdlLocation(), DAY_COUNTER_SERVICE_IMPL_QNAME);
    }

    @WebEndpoint(name = "DayCounterServiceImplPort")
    public DayCounterService getDayCounterServiceImplPort() {
        return super.getPort(new QName("http://lab9.soa.agh.edu.pl/", "DayCounterServiceImplPort"), DayCounterService.class);
    }

    private static URL __getWsdlLocation() {
        if (DAY_COUNTER_SERVICE_IMPL_EXCEPTION != null) {
            throw DAY_COUNTER_SERVICE_IMPL_EXCEPTION;
        }
        return DAY_COUNTER_SERVICE_IMPL_WSDL_LOCATION;
    }

}
