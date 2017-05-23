package pl.edu.agh.soa.projekt.pas.controller;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.repository.ParkingPlaceRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class DashboardController {

    // TODO: 23.05.2017 zrobić ogólny service, z którego będzie korzystać reszta
    @EJB
    private ParkingPlaceRepository parkingPlaceRepository;

    public List<ParkingPlace> getParkingPlaces() {
        return parkingPlaceRepository.findAll();
    }

}
