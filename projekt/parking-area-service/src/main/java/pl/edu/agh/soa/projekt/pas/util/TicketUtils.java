package pl.edu.agh.soa.projekt.pas.util;

import pl.edu.agh.soa.projekt.pas.model.Ticket;

public class TicketUtils {

    public static boolean isExpired(Ticket t) {
        return t.getExpirationTime() < System.currentTimeMillis();
    }

    public static boolean isNotExpired(Ticket t) {
        return !isExpired(t);
    }

}
