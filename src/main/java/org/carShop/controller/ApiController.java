package org.carShop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.carShop.model.Car;
import org.carShop.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Cars")
@RestController
public class ApiController {
    private final String base = "/api";
    private CarRepository carRepository;

    ApiController() {
        carRepository = new CarRepository();
    }

    @ApiOperation(value = "View a list of available cars")
    @RequestMapping(value = { base + "/cars" }, method = RequestMethod.GET, produces = "application/json")
    public List<Car> listCars() {

        return carRepository.findAll();
    }

    @ApiOperation(value = "View a single car")
    @RequestMapping(value = { base + "/cars/{id}" }, method = RequestMethod.GET, produces = "application/json")
    public Car findCar(@PathVariable("id") int id) {

        return carRepository.findById(id);
    }

    @ApiOperation(value = "Add a new car")
    @RequestMapping(value = { base + "/create" }, method = RequestMethod.POST)
    public void createCar(@RequestParam String brand, @RequestParam String type) {
        Car car = new Car(brand, type);
        carRepository.save(car);
    }

    @ApiOperation(value = "Update a car")
    @RequestMapping(value = { base + "/update" }, method = RequestMethod.PUT)
    public void updateCar(
        @RequestParam int targetId,
        @RequestParam(required = false) String brand,
        @RequestParam(required = false) String type) {

        Car carToUpdate = carRepository.findById(targetId);
        if (brand != null) { carToUpdate.setBrand(brand); }
        if (type != null) { carToUpdate.setType(type); }
    }

    @ApiOperation(value = "Delete a car")
    @RequestMapping(value = { base + "/delete" }, method = RequestMethod.DELETE)
    public void deleteCar(@RequestParam int targetId) {

        carRepository.delete(targetId);
    }
}
