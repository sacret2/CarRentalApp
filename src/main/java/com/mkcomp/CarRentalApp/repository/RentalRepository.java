package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
