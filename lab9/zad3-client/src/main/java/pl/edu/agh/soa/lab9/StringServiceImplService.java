package pl.edu.agh.soa.lab9;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(name = "StringServiceImplService", targetNamespace = "http://lab9.soa.agh.edu.pl/", wsdlLocation = "http://localhost:8080/zad3-service/StringServiceImpl?wsdl")
public class StringServiceImplService
        extends Service {

    private final static URL STRING_SERVICE_IMPL_WSDL_LOCATION;
    private final static WebServiceException STRING_SERVICE_IMPL_EXCEPTION;
    private final static QName STRING_SERVICE_IMPL_QNAME = new QName("http://lab9.soa.agh.edu.pl/", "StringServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/zad3-service/StringServiceImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STRING_SERVICE_IMPL_WSDL_LOCATION = url;
        STRING_SERVICE_IMPL_EXCEPTION = e;
    }

    public StringServiceImplService() {
        super(__getWsdlLocation(), STRING_SERVICE_IMPL_QNAME);
    }

    @WebEndpoint(name = "StringServiceImplPort")
    public StringService getStringServiceImplPort() {
        return super.getPort(new QName("http://lab9.soa.agh.edu.pl/", "StringServiceImplPort"), StringService.class);
    }

    private static URL __getWsdlLocation() {
        if (STRING_SERVICE_IMPL_EXCEPTION != null) {
            throw STRING_SERVICE_IMPL_EXCEPTION;
        }
        return STRING_SERVICE_IMPL_WSDL_LOCATION;
    }

}
