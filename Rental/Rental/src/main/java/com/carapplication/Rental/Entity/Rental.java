package com.carapplication.Rental.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getNoofdays() {
        return noofdays;
    }

    public void setNoofdays(int noofdays) {
        this.noofdays = (int) ChronoUnit.DAYS.between(startDate,endDate);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = this.noofdays * car.getPricePerDay();
    }

    public Rental(Car car, LocalDate startDate, LocalDate endDate) {
        this.car = car.getCar();
        this.startDate = startDate;
        this.endDate = endDate;
        this.noofdays = (int)ChronoUnit.DAYS.between(endDate,startDate);
        this.totalPrice = noofdays ;
    }







    public Rental() {



    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", car=" + car +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", noofdays=" + noofdays +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
