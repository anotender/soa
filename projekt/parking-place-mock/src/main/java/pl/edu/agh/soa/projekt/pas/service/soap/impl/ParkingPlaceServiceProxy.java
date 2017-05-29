package pl.edu.agh.soa.projekt.pas.service.soap.impl;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(
        name = "ParkingPlaceServiceImplService",
        targetNamespace = "http://impl.soap.service.pas.projekt.soa.agh.edu.pl/",
        wsdlLocation = "http://localhost:8080/parking-area-service/ParkingPlaceServiceImpl?wsdl"
)
public class ParkingPlaceServiceProxy extends Service {

    private final static URL PARKING_PLACE_SERVICE_IMPL_SERVICE_WSDL_LOCATION;
    private final static WebServiceException PARKING_PLACE_SERVICE_IMPL_SERVICE_EXCEPTION;
    private final static QName PARKING_PLACE_SERVICE_IMPL_SERVICE_QNAME = new QName("http://impl.soap.service.pas.projekt.soa.agh.edu.pl/", "ParkingPlaceServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/parking-area-service/ParkingPlaceServiceImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PARKING_PLACE_SERVICE_IMPL_SERVICE_WSDL_LOCATION = url;
        PARKING_PLACE_SERVICE_IMPL_SERVICE_EXCEPTION = e;
    }

    public ParkingPlaceServiceProxy() {
        super(getWsdlLocation(), PARKING_PLACE_SERVICE_IMPL_SERVICE_QNAME);
    }

    @WebEndpoint(name = "ParkingPlaceServiceImplPort")
    public ParkingPlaceService getParkingPlaceServiceImplPort() {
        QName portName = new QName(
                "http://impl.soap.service.pas.projekt.soa.agh.edu.pl/",
                "ParkingPlaceServiceImplPort"
        );
        return super.getPort(portName, ParkingPlaceService.class);
    }

    private static URL getWsdlLocation() {
        if (PARKING_PLACE_SERVICE_IMPL_SERVICE_EXCEPTION != null) {
            throw PARKING_PLACE_SERVICE_IMPL_SERVICE_EXCEPTION;
        }
        return PARKING_PLACE_SERVICE_IMPL_SERVICE_WSDL_LOCATION;
    }

}
