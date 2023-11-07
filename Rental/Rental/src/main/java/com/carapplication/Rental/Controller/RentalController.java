package com.carapplication.Rental.Controller;

import com.carapplication.Rental.Entity.Car;
import com.carapplication.Rental.Entity.Rental;
import com.carapplication.Rental.Service.RentalService;
import com.carapplication.Rental.dto.RentalDateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
public class RentalController {
    @Autowired
    private RentalService rentalService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getallrentals")
    public List<Rental> getAllRentals() {
        List<Rental> rental = rentalService.getAllRentals();
//        Car car=this.restTemplate.getForObject("http://localhost:8080/car/{id}", Car.class);
//        rental.set();
        return rental;
    }



    @GetMapping("/rentalsearch/{id}")
    public Rental getRentalById(@PathVariable Long id) {
        Rental rental = rentalService.getRentalById(id);
        Car car=this.restTemplate.getForObject("http://localhost:8080/car/"+id, Car.class);
        rental.setCar(car);
        return rental;
    }

    @PostMapping("/rental-add")
    public Rental addRental(@RequestBody Rental rental) {
        return rentalService.saveRental(rental).getCar();

    }


    @DeleteMapping("/delete-rental/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);

    }
}

