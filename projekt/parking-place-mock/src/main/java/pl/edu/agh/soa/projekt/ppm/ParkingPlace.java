package pl.edu.agh.soa.projekt.ppm;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ParkingPlace {
    private String parkingPlaceId;

    public void take() {
        System.out.println("Taking parking place with ID: " + parkingPlaceId);
    }

    public void leave() {
        System.out.println("Leaving parking place with ID: " + parkingPlaceId);
    }

    public String getParkingPlaceId() {
        return parkingPlaceId;
    }

    public void setParkingPlaceId(String parkingPlaceId) {
        this.parkingPlaceId = parkingPlaceId;
    }
}
