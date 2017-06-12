package pl.edu.agh.soa.projekt.pas.service.area.soap.impl;

import pl.edu.agh.soa.projekt.pas.model.dto.AreaDTO;
import pl.edu.agh.soa.projekt.pas.service.area.AreaService;
import pl.edu.agh.soa.projekt.pas.service.area.soap.api.AreaSOAPService;

import javax.ejb.EJB;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "pl.edu.agh.soa.projekt.pas.service.area.soap.api.AreaSOAPService")
public class AreaSOAPServiceImpl implements AreaSOAPService {

    @EJB
    private AreaService areaService;

    @Override
    public List<AreaDTO> getAreas() {
        return areaService.getAreaDTOs();
    }
}
