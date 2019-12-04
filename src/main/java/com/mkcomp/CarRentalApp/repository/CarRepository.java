package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
