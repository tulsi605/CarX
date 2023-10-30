package com.carServices.carService.service;

import com.carServices.carService.carRepository.CarRepository;
import com.carServices.carService.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public List<Car> getallCars()
    {
        return carRepository.findAll();
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }

    public Car getCarById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }
}
