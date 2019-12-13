package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Branch;
import com.mkcomp.CarRentalApp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface between Postgres database and application logic declaring CRUD methods for Car objects
 */
public interface CarRepository extends JpaRepository<Car, Long> {

        List<Car> findAllFromBranch(Branch branch);
}
