package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface between Postgres database and application logic declaring CRUD methods for Rental objects
 */
public interface RentalRepository extends JpaRepository<Rental, Long> {
}
