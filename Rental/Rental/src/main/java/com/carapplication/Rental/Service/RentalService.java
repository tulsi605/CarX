package com.carapplication.Rental.Service;

import com.carapplication.Rental.Entity.Rental;
import com.carapplication.Rental.Repository.RentalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
            return rentalRepository.findAll();
    }
    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }


    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}