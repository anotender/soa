package pl.edu.agh.soa.projekt.ppm;

import pl.edu.agh.soa.projekt.pas.service.soap.impl.ParkingPlaceService;
import pl.edu.agh.soa.projekt.pas.service.soap.impl.ParkingPlaceServiceImplService;

import javax.faces.bean.ManagedBean;

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
        return new ParkingPlaceServiceImplService().getParkingPlaceServiceImplPort();
    }
}
