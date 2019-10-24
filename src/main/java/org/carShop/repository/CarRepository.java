package org.carShop.repository;

import org.carShop.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
//public class CarRepository implements CarInterface {
//    private static List<Car> cars = new ArrayList<>();
//
//    @Override
//    public List<Car> findAll() {
//        return cars;
//    }
//
//    @Override
//    public Car findById(int id) {
//        for (Car car : cars) {
//            if (car.getId() == id) {
//                return car;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Object save(Car car) {
//        cars.add(car);
//        return null;
//    }
//
//    @Override
//    public void delete(int id) {
//        cars.removeIf(car -> (car.getId() == id));
//    }
//}
