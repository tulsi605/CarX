package com.carappliction.Car.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private int year;
    private String color;
    private int pricePerDay;
    private boolean available;

    public Car(Long id, String make, String model, int year, String color, int pricePerDay, boolean available) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.pricePerDay = pricePerDay;
        this.available = available;
    }

    public Car() {
    }
}

