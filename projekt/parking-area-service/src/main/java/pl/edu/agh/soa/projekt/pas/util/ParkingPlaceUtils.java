package pl.edu.agh.soa.projekt.pas.util;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;

import java.util.Objects;

public class ParkingPlaceUtils {

    public static boolean hasNoTicket(ParkingPlace p) {
        return Objects.isNull(p.getTicket());
    }

    public static boolean hasExpiredTicket(ParkingPlace p) {
        return TicketUtils.isExpired(p.getTicket());
    }

}
