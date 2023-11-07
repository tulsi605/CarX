package com.carappliction.Car.Service;

import com.carappliction.Car.Entity.Car;
import com.carappliction.Car.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
//        Optional<Car> savedCar = carRepository.findById(car.getId());
//        if(savedCar.isPresent()){
//            throw new IllegalStateException("Car already Exists");
//        } else{
//            carRepository.save(car);
//        }

    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }


}

