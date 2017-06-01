package pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.impl;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(
        name = "ParkingPlaceSOAPServiceImplService",
        targetNamespace = "http://impl.soap.parkingplace.service.pas.projekt.soa.agh.edu.pl/",
        wsdlLocation = "http://localhost:8080/parking-area-service/ParkingPlaceSOAPServiceImpl?wsdl"
)
public class ParkingPlaceSOAPServiceProxy extends Service {

    private final static URL PARKING_PLACE_SOAP_SERVICE_IMPL_WSDL_LOCATION;
    private final static WebServiceException PARKING_PLACE_SOAP_SERVICE_IMPL_EXCEPTION;
    private final static QName PARKING_PLACE_SOAP_SERVICE_IMPL_QNAME = new QName("http://impl.soap.parkingplace.service.pas.projekt.soa.agh.edu.pl/", "ParkingPlaceSOAPServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/parking-area-service/ParkingPlaceSOAPServiceImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PARKING_PLACE_SOAP_SERVICE_IMPL_WSDL_LOCATION = url;
        PARKING_PLACE_SOAP_SERVICE_IMPL_EXCEPTION = e;
    }

    public ParkingPlaceSOAPServiceProxy() {
        super(__getWsdlLocation(), PARKING_PLACE_SOAP_SERVICE_IMPL_QNAME);
    }

    @WebEndpoint(name = "ParkingPlaceSOAPServiceImplPort")
    public ParkingPlaceSOAPService getParkingPlaceSOAPServiceImplPort() {
        return super.getPort(new QName("http://impl.soap.parkingplace.service.pas.projekt.soa.agh.edu.pl/", "ParkingPlaceSOAPServiceImplPort"), ParkingPlaceSOAPService.class);
    }

    private static URL __getWsdlLocation() {
        if (PARKING_PLACE_SOAP_SERVICE_IMPL_EXCEPTION != null) {
            throw PARKING_PLACE_SOAP_SERVICE_IMPL_EXCEPTION;
        }
        return PARKING_PLACE_SOAP_SERVICE_IMPL_WSDL_LOCATION;
    }

}
