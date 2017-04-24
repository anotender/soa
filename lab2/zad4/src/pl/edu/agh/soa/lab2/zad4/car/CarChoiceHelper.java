package pl.edu.agh.soa.lab2.zad4.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarChoiceHelper {

    private List<Car> cars;

    public CarChoiceHelper() {
        cars = Arrays.asList(
                new Car("Mercedes", "luksusowy", 200000),
                new Car("Aston Martin", "sportowy", 500000),
                new Car("Mini", "miejski", 50000),
                new Car("BMW", "luksusowy", 150000)
        );
    }

    public List<String> getSuitableModels(String typ, int min, int max) {
        return cars
                .stream()
                .filter(c -> c.getType().equals(typ))
                .filter(c -> min <= c.getPrice() && c.getPrice() <= max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
