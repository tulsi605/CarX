package com.carappliction.Car.Repository;

import com.carappliction.Car.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
