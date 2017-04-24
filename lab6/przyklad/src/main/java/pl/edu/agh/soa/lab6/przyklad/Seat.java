package pl.edu.agh.soa.lab6.przyklad;

public class Seat {

    private int id;
    private String place;
    private int price;
    private boolean booked;

    public Seat(int id, String place, int price) {
        this.id = id;
        this.place = place;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
