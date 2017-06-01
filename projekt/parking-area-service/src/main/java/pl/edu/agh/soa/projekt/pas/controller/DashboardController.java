package pl.edu.agh.soa.projekt.pas.controller;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.repository.ParkingPlaceRepository;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;
import pl.edu.agh.soa.projekt.pas.util.ParkingAreaUtils;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class DashboardController {

    @EJB
    private ParkingPlaceService parkingPlaceService;

    public List<ParkingPlace> getParkingPlaces() {
        return parkingPlaceService.getParkingPlaces();
    }

    public boolean isOccupiedWithoutTicket(ParkingPlace p) {
        return ParkingAreaUtils.isOccupiedWithoutTicket(p);
    }
}
