package pl.edu.agh.soa.projekt.pas.service.area.soap.api;

import pl.edu.agh.soa.projekt.pas.model.dto.AreaDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

import static javax.jws.soap.SOAPBinding.Style.RPC;

@WebService
@SOAPBinding(style = RPC)
public interface AreaSOAPService {
    @WebMethod
    List<AreaDTO> getAreas();
}
