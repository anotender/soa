package pl.edu.agh.soa.projekt.pas.service.parkingplace;


import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.model.User;
import pl.edu.agh.soa.projekt.pas.repository.ParkingPlaceRepository;
import pl.edu.agh.soa.projekt.pas.util.SecurityUtils;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@Startup
@Transactional
public class ParkingPlaceService {

    @EJB
    private ParkingPlaceRepository parkingPlaceRepository;

    public ParkingPlace getParkingPlace(long id) {
        return parkingPlaceRepository
                .findOne(id)
                .orElseThrow(RuntimeException::new);
    }

    public List<ParkingPlace> getParkingPlaces() {
        return parkingPlaceRepository.findAll();
    }

    public List<ParkingPlace> getParkingPlacesForLoggedUser() {
        User user = SecurityUtils
                .getLoggedUser()
                .orElseThrow(RuntimeException::new);

        if (SecurityUtils.isAdmin(user)) {
            return getParkingPlaces();
        }

        return getParkingPlaces()
                .stream()
                .filter(p -> p.getStreet().getArea().equals(user.getArea()))
                .collect(Collectors.toList());
    }

    public void updateParkingPlace(ParkingPlace parkingPlace) {
        parkingPlaceRepository.update(parkingPlace);
    }
}
