package pl.edu.agh.soa.projekt.ppm;

import pl.edu.agh.soa.projekt.pas.service.soap.api.ParkingPlaceService;

import javax.faces.bean.ManagedBean;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

@ManagedBean
public class ParkingPlace {
    private ParkingPlaceService parkingPlaceService = getParkingPlaceService();
    private long parkingPlaceId;

    public void take() {
        parkingPlaceService.takePlace(parkingPlaceId);
    }

    public void leave() {
        parkingPlaceService.leavePlace(parkingPlaceId);
    }

    public long getParkingPlaceId() {
        return parkingPlaceId;
    }

    public void setParkingPlaceId(long parkingPlaceId) {
        this.parkingPlaceId = parkingPlaceId;
    }

    private ParkingPlaceService getParkingPlaceService() {
        try {
            return Service
                    .create(
                            new URL("http://localhost:8080/parking-area-service/ParkingPlaceServiceImpl?wsdl"),
                            new QName("http://impl.soap.service.pas.projekt.soa.agh.edu.pl/", "ParkingPlaceServiceImplService")
                    )
                    .getPort(ParkingPlaceService.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
