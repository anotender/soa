package pl.edu.agh.soa.projekt.pas.service.parkingplace;


import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.repository.ParkingPlaceRepository;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.List;

@Singleton
@Startup
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

    public void updateParkingPlace(ParkingPlace parkingPlace) {
        parkingPlaceRepository.update(parkingPlace);
    }

}
