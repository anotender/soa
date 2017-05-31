package pl.edu.agh.soa.lab9;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "StringService", targetNamespace = "http://lab9.soa.agh.edu.pl/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
        ObjectFactory.class
})
public interface StringService {

    @WebMethod
    @WebResult(partName = "return")
    StringStats getStringStats(@WebParam(name = "string", partName = "string") String string);

}
