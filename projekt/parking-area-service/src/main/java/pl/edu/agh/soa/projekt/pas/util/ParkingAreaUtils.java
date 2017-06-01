package pl.edu.agh.soa.projekt.pas.util;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;

public class ParkingAreaUtils {

    public static boolean isOccupiedWithoutTicket(ParkingPlace p) {
        return p.isOccupied() && p.getTicket() == null;
    }

}
