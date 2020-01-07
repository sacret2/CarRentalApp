package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface between Postgres database and application logic declaring CRUD methods for Customer objects.
 * Those methods are implemented by Hibernate, providing access to database from java code in Service objects.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByUserNameAndPassword(String userName, String password);
}
