package pl.edu.agh.soa.lab2.zad4.car;

/**
 * Created by student on 16/03/17.
 */
public class Car {

    private String name;
    private String type;
    private int price;

    public Car(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
