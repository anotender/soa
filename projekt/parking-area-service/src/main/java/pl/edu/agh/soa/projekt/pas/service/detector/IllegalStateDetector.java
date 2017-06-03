package pl.edu.agh.soa.projekt.pas.service.detector;

import pl.edu.agh.soa.projekt.pas.model.Ticket;
import pl.edu.agh.soa.projekt.pas.service.ticket.TicketService;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Singleton
@Startup
public class IllegalStateDetector {

    @EJB
    private TicketService ticketService;

    private Ticket ticketToExpire;

    public void registerTicket(Ticket ticket) {
        if (Objects.isNull(ticketToExpire) || expiresEarlier(ticket)) {
            ticketToExpire = ticket;
            Executors
                    .newSingleThreadScheduledExecutor()
                    .schedule(
                            new NotificationHandler(),
                            ticketToExpire.getExpirationTime() - System.currentTimeMillis(),
                            TimeUnit.MILLISECONDS
                    );
        }
    }

    private void unregisterTicket() {
        ticketToExpire = null;
    }

    private boolean expiresEarlier(Ticket ticket) {
        return ticket.getExpirationTime() < ticketToExpire.getExpirationTime();
    }

    private class NotificationHandler implements Runnable {
        @Override
        public void run() {
            System.out.println("executed...");
            /*unregisterTicket();
            Ticket ticket = ticketService.getFirstTicketToExpire();
            registerTicket(ticket);*/
        }
    }

}