package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Branch;
import com.mkcomp.CarRentalApp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

        List<Car> findAllByBranchIs(Branch branch);
}
