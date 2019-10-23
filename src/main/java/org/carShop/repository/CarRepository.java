package org.carShop.repository;

import org.carShop.model.Car;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository implements CarInterface {
    private static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("Peugeot", "205"));
        cars.add(new Car("Renault", "R19"));
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Car findById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void save(Car car) {

    }

    @Override
    public void delete(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                cars.remove(cars.indexOf(car));
            }
        }
    }
}
