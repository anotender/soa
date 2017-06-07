package pl.edu.agh.soa.projekt.pas.service.street;

import pl.edu.agh.soa.projekt.pas.model.Street;
import pl.edu.agh.soa.projekt.pas.repository.StreetRepository;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Startup
@Transactional
public class StreetService {
    @EJB
    private StreetRepository streetRepository;

    public Street getStreet(Long id) {
        return streetRepository
                .findOne(id)
                .orElseThrow(RuntimeException::new);
    }

    public List<Street> getStreets() {
        return streetRepository.findAll();
    }
}
