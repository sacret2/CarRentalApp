package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface between Postgres database and application logic declaring CRUD methods for Customer objects
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByUserNameAndPassword(String userName, String password);
}
