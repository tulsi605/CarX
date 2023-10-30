package com.carapplication.Rental.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter

@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private int noofdays;
    private int totalPrice;

    public Rental( Car car, LocalDate startDate, LocalDate endDate) {
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noofdays = (int) ChronoUnit.DAYS.between(startDate,endDate);;
        this.totalPrice = noofdays * car.getPricePerDay();;
    }

    public Rental() {
    }


}