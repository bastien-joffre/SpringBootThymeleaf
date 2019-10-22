package org.carShop.store;

import org.carShop.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarStore {
    private static List<Car> cars = new ArrayList<>();
    private static int cursorCarId;

    static {
        cars.add(new Car("Peugeot", "205", giveId()));
        cars.add(new Car("Renault", "R19", giveId()));
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static void addCar(String brand, String type) {
        Car newCar = new Car(brand, type, giveId());
        cars.add(newCar);
    }

    public static Car findCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public static void deleteCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                cars.remove(cars.indexOf(car));
            }
        }
    }

    private static int giveId() {
        int id = cursorCarId;
        cursorCarId++;
        return id;
    }
}
