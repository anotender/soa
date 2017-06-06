package pl.edu.agh.soa.projekt.pas.controller;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static pl.edu.agh.soa.projekt.pas.util.ParkingPlaceUtils.hasExpiredTicket;
import static pl.edu.agh.soa.projekt.pas.util.ParkingPlaceUtils.hasNoTicket;

@ManagedBean
@SessionScoped
@MessageDriven(
        name = "DashboardController",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/illegal-state-topic")
        }
)
public class DashboardController implements MessageListener {

    @EJB
    private ParkingPlaceService parkingPlaceService;

    public List<ParkingPlace> getParkingPlaces() {
        return parkingPlaceService.getParkingPlacesForLoggedUser();
    }

    public String getFormattedTime(long time) {
        if (time == 0) {
            return "";
        }
        return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date(time));
    }

    public String getContentStyle(ParkingPlace p) {
        return hasIllegalState(p) ? "color:red" : "";
    }

    private boolean hasIllegalState(ParkingPlace p) {
        return p.isOccupied() && (hasNoTicket(p) || hasExpiredTicket(p));
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("received...");
            System.out.println(message.getLongProperty("parkingPlaceId"));
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
