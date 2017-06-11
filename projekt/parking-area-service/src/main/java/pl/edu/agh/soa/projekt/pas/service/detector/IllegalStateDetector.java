package pl.edu.agh.soa.projekt.pas.service.detector;

import pl.edu.agh.soa.projekt.pas.model.Ticket;
import pl.edu.agh.soa.projekt.pas.service.ticket.TicketService;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Objects;
import java.util.concurrent.*;

@Singleton
@Startup
public class IllegalStateDetector {

    @EJB
    private TicketService ticketService;

    @EJB
    private NotificationHandler notificationHandler;

    private Ticket ticketToExpire;

    private ScheduledFuture<?> scheduledFuture;

    public void registerTicket(Ticket ticket) {
        if (Objects.isNull(ticketToExpire) || expiresEarlier(ticket)) {
            ticketToExpire = ticket;
            CompletableFuture
                    .runAsync(() -> {
                        try {
                            scheduledFuture = Executors
                                    .newSingleThreadScheduledExecutor()
                                    .schedule(
                                            () -> notificationHandler.sendMessage(prepareMessage()),
                                            ticketToExpire.getExpirationTime() - System.currentTimeMillis(),
                                            TimeUnit.MILLISECONDS
                                    );

                            scheduledFuture.get();
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

    public void unregisterTicket(Ticket ticket) {
        if (Objects.nonNull(ticketToExpire) && ticket.getId().equals(ticketToExpire.getId())) {
            scheduledFuture.cancel(true);
            ticketToExpire = null;
        }
    }

    private boolean expiresEarlier(Ticket ticket) {
        return ticket.getExpirationTime() < ticketToExpire.getExpirationTime();
    }

    private String prepareMessage() {
        return "Ticket for parking place with id: " + ticketToExpire.getParkingPlace().getId() + " has just expired";
    }
}
