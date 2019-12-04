package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
