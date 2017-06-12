package pl.edu.agh.soa.projekt.pas.service.street;

import pl.edu.agh.soa.projekt.pas.model.dto.StreetDTO;
import pl.edu.agh.soa.projekt.pas.repository.StreetRepository;
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
public class StreetService {
    @EJB
    private StreetRepository streetRepository;

    public StreetDTO getStreetDTO(Long id) {
        return streetRepository
                .findOne(id)
                .map(DTOMapper::mapStreetToStreetDTO)
                .orElseThrow(RuntimeException::new);
    }

    public List<StreetDTO> getStreetDTOs() {
        return streetRepository
                .findAll()
                .stream()
                .map(DTOMapper::mapStreetToStreetDTO)
                .collect(Collectors.toList());
    }

    public List<StreetDTO> getStreetDTOsForArea(Long id) {
        return streetRepository
                .findByAreaId(id)
                .stream()
                .map(DTOMapper::mapStreetToStreetDTO)
                .collect(Collectors.toList());
    }
}
