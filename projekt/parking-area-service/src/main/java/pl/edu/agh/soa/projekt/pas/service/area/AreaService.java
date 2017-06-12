package pl.edu.agh.soa.projekt.pas.service.area;

import pl.edu.agh.soa.projekt.pas.model.dto.AreaDTO;
import pl.edu.agh.soa.projekt.pas.repository.AreaRepository;
import pl.edu.agh.soa.projekt.pas.util.DTOMapper;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@Startup
@Transactional
public class AreaService {

    @EJB
    private AreaRepository areaRepository;

    public AreaDTO getAreaDTO(Long id) {
        return areaRepository
                .findOne(id)
                .map(DTOMapper::mapAreaToAreaDTO)
                .orElseThrow(RuntimeException::new);
    }

    public AreaDTO getAreaDTOByStreetId(Long id) {
        return areaRepository
                .findOneByStreetId(id)
                .map(DTOMapper::mapAreaToAreaDTO)
                .orElseThrow(RuntimeException::new);
    }

    public List<AreaDTO> getAreaDTOs() {
        return areaRepository
                .findAll()
                .stream()
                .map(DTOMapper::mapAreaToAreaDTO)
                .collect(Collectors.toList());
    }
}
