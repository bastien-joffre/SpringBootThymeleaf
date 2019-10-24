package org.carShop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.carShop.model.Car;
import org.carShop.repository.CarInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Cars")
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private CarInterface carInterface;

    @ApiOperation(value = "View a list of available cars")
    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = "application/json")
    public List<Car> listCars() {

        return carInterface.findAll();
    }

    @ApiOperation(value = "View a single car")
    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
    public Car findCar(@PathVariable int id) {

        return carInterface.findById(id);
    }

    @ApiOperation(value = "Add a new car")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createCar(@RequestBody Car car) {

        carInterface.save(car);
    }

    @ApiOperation(value = "Update a car")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateCar(@RequestBody Car car) {

        carInterface.save(car);
    }

    @ApiOperation(value = "Delete a car")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable int id) {

        carInterface.deleteById(id);
    }
}
