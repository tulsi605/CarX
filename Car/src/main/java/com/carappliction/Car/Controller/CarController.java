package com.carappliction.Car.Controller;

import com.carappliction.Car.Entity.Car;
import com.carappliction.Car.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/show-allcars")
    public List<Car> getAllCars(Model model) {
        List<Car> car = carService.getAllCars();
//        model.addAttribute("getallcars", car);
        return car;
    }

    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        return car;
    }

    @PostMapping("/save-car")
    public Car saveCar( @RequestBody Car car){
        System.out.println(car);
        return carService.saveCar(car);
    }

//    @PutMapping("/update-car")
//    public Car updateCar(@RequestBody Car car){
//        return carService.updatecar(car);
//    }

    @DeleteMapping("/delete-car/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }
}
