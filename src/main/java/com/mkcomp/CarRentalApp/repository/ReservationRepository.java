package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Customer;
import com.mkcomp.CarRentalApp.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface between Postgres database and application logic declaring CRUD methods for Reservation objects.
 * Those methods are implemented by Hibernate, providing access to database from java code in Service objects.
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByCustomerIs(Customer customer);
}
