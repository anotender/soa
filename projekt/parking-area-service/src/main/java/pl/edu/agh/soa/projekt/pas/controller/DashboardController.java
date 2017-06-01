package pl.edu.agh.soa.projekt.pas.controller;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

import static pl.edu.agh.soa.projekt.pas.util.ParkingAreaUtils.hasExpiredTicket;
import static pl.edu.agh.soa.projekt.pas.util.ParkingAreaUtils.hasNoTicket;

@ManagedBean
public class DashboardController {

    @EJB
    private ParkingPlaceService parkingPlaceService;

    public List<ParkingPlace> getParkingPlaces() {
        return parkingPlaceService.getParkingPlaces();
    }

    public boolean hasIllegalState(ParkingPlace p) {
        return p.isOccupied() && (hasNoTicket(p) || hasExpiredTicket(p));
    }
}
