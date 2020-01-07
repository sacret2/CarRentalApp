package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface between Postgres database and application logic declaring CRUD methods for Employee objects.
 * Those methods are implemented by Hibernate, providing access to database from java code in Service objects.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByUserNameAndPassword(String userName, String password);
}
