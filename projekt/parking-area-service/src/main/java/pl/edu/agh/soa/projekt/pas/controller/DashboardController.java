package pl.edu.agh.soa.projekt.pas.controller;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static pl.edu.agh.soa.projekt.pas.util.ParkingPlaceUtils.hasExpiredTicket;
import static pl.edu.agh.soa.projekt.pas.util.ParkingPlaceUtils.hasNoTicket;

@ManagedBean
@SessionScoped
public class DashboardController {

    @EJB
    private ParkingPlaceService parkingPlaceService;

    public String getFormattedTime(long time) {
        if (time == 0) {
            return "No ticket";
        }
        return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date(time));
    }

    public String getContentStyle(ParkingPlace p) {
        return hasIllegalState(p) ? "color:red" : "";
    }

    public List<ParkingPlace> getParkingPlaces() {
        return parkingPlaceService.getParkingPlacesForLoggedUser();
    }

    private boolean hasIllegalState(ParkingPlace p) {
        return p.isOccupied() && (hasNoTicket(p) || hasExpiredTicket(p));
    }
}
