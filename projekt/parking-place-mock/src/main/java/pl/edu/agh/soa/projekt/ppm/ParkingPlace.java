package pl.edu.agh.soa.projekt.ppm;

import pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.impl.ParkingPlaceSOAPService;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.impl.ParkingPlaceSOAPServiceProxy;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ParkingPlace {
    private ParkingPlaceSOAPService parkingPlaceService = getParkingPlaceService();
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

    private ParkingPlaceSOAPService getParkingPlaceService() {
        return new ParkingPlaceSOAPServiceProxy().getParkingPlaceSOAPServiceImplPort();
    }
}
