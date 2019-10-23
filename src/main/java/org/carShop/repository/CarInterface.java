package org.carShop.repository;

import org.carShop.model.Car;

import java.util.List;

public interface CarInterface {
    List<Car> findAll();

    Car findById(int id);

    void save(Car car);

    void delete(int id);
}
