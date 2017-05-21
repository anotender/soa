package pl.edu.agh.soa.projekt.pmm;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ParkingMeter {
    private String parkingMeterId;
    private int minutes;

    public void getTicket() {
        System.out.println("Getting ticket from parking meter with ID: " + parkingMeterId + " for " + minutes);
    }

    public String getParkingMeterId() {
        return parkingMeterId;
    }

    public void setParkingMeterId(String parkingMeterId) {
        this.parkingMeterId = parkingMeterId;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
