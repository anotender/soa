package pl.edu.agh.soa.projekt.pas.service.detector;

import pl.edu.agh.soa.projekt.pas.model.Ticket;
import pl.edu.agh.soa.projekt.pas.service.ticket.TicketService;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Singleton
@Startup
public class IllegalStateDetector {

    @EJB
    private TicketService ticketService;

    @EJB
    private NotificationHandler notificationHandler;

    private Ticket ticketToExpire;

    public void registerTicket(Ticket ticket) {
        if (Objects.isNull(ticketToExpire) || expiresEarlier(ticket)) {
            ticketToExpire = ticket;
            CompletableFuture
                    .runAsync(() -> {
                        try {
                            Executors
                                    .newSingleThreadScheduledExecutor()
                                    .schedule(
                                            () -> notificationHandler.notifyUsers(ticketToExpire.getParkingPlace().getId()),
                                            ticketToExpire.getExpirationTime() - System.currentTimeMillis(),
                                            TimeUnit.MILLISECONDS
                                    )
                                    .get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .thenRun(() -> {
                        ticketToExpire = null;
                        ticketService.getFirstTicketToExpire().ifPresent(this::registerTicket);
                    });
        }
    }

    private boolean expiresEarlier(Ticket ticket) {
        return ticket.getExpirationTime() < ticketToExpire.getExpirationTime();
    }

}
