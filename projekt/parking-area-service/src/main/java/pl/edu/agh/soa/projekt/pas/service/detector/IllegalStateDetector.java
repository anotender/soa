package pl.edu.agh.soa.projekt.pas.service.detector;

import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;
import pl.edu.agh.soa.projekt.pas.util.ParkingAreaUtils;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import static javax.ejb.LockType.READ;

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
                .filter(ParkingAreaUtils::isOccupiedWithoutTicket)
                .forEach(parkingPlace -> System.out.println(parkingPlace.getId()));
    }


}
