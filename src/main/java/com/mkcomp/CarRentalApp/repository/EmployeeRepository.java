package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByUserNameAndPassword(String userName, String password);
}
