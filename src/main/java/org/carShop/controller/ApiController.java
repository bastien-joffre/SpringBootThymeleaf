package org.carShop.controller;

import org.carShop.model.Car;
import org.carShop.store.CarStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @RequestMapping(value = { "/api/list" }, method = RequestMethod.GET, produces = "application/json")
    public List<Car> listCars() {

        return CarStore.getCars();
    }

    @RequestMapping(value = { "/api/create" }, method = RequestMethod.PUT)
    public void createCar(@RequestParam String brand, @RequestParam String type) {

        CarStore.addCar(brand, type);
    }

    @RequestMapping(value = { "/api/update" }, method = RequestMethod.POST)
    public void updateCar(
        @RequestParam int targetId,
        @RequestParam(required = false) String brand,
        @RequestParam(required = false) String type) {

        Car carToUpdate = CarStore.findCar(targetId);
        if (brand != null) { carToUpdate.setBrand(brand); }
        if (type != null) { carToUpdate.setType(type); }
    }

    @RequestMapping(value = { "/api/delete" }, method = RequestMethod.DELETE)
    public void deleteCar(@RequestParam int targetId) {

        CarStore.deleteCar(targetId);
    }
}
