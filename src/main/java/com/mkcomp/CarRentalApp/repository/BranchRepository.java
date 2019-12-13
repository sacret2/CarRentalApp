package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface between Postgres database and application logic declaring CRUD methods for Branch objects
 */
public interface BranchRepository extends JpaRepository<Branch, Long> {
}
