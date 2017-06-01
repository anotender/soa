package pl.edu.agh.soa.projekt.pas.service.detector;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import static javax.ejb.LockType.READ;
import static pl.edu.agh.soa.projekt.pas.util.ParkingAreaUtils.hasExpiredTicket;
import static pl.edu.agh.soa.projekt.pas.util.ParkingAreaUtils.hasNoTicket;

@Singleton
public class IllegalStateDetector {

    @EJB
    private ParkingPlaceService parkingPlaceService;

    @Lock(READ)
    @Schedule(second = "*/30", minute = "*", hour = "*", persistent = false)
    public void detectIllegalState() {
        parkingPlaceService
                .getParkingPlaces()
                .stream()
                .filter(ParkingPlace::isOccupied)
                .filter(p -> hasNoTicket(p) || hasExpiredTicket(p))
                .forEach(p -> System.out.println(p.getId()));
    }

}
