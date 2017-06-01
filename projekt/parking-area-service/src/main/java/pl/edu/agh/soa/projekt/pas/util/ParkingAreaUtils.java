package pl.edu.agh.soa.projekt.pas.util;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.model.Ticket;

import java.util.Objects;

public class ParkingAreaUtils {

    public static boolean hasNoTicket(ParkingPlace p) {
        return Objects.isNull(p.getTicket());
    }

    public static boolean hasExpiredTicket(ParkingPlace p) {
        return isTicketExpired(p.getTicket());
    }

    private static boolean isTicketExpired(Ticket t) {
        return t.getExpirationTime() < System.currentTimeMillis();
    }

}
