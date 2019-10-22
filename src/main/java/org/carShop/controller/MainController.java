package org.carShop.controller;

import org.carShop.form.CarForm;
import org.carShop.model.Car;
import org.carShop.store.CarStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/carList" }, method = RequestMethod.GET)
    public String carList(Model model) {

        model.addAttribute("cars", CarStore.getCars());

        return "carList";
    }

    @RequestMapping(value = { "/addCar" }, method = RequestMethod.GET)
    public String showAddCarPage(Model model) {

        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);

        return "addCar";
    }

    @RequestMapping(value = { "/addCar" }, method = RequestMethod.POST)
    public String saveCar(Model model, //
        @ModelAttribute("carForm") CarForm carForm) {

        String brand = carForm.getBrand();
        String type = carForm.getType();

        if (brand != null && brand.length() > 0 //
                && type != null && type.length() > 0) {
            CarStore.addCar(brand, type);

            return "redirect:/carList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }

}