package org.carShop.repository;

import org.carShop.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInterface extends JpaRepository<Car, Integer> {
//    List<Car> findAll();
//
    Car findById(int id);
//
//    Car save(Car car);
//
//    void delete(int id);
}
