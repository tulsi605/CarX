package com.carapplication.Service.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    String service_name;
    int price;

    public Service(Long id, String service_name, int price) {
        this.id = id;
        this.service_name = service_name;
        this.price = price;
    }

    public Service() {
    }
}

