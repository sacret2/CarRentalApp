package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface between Postgres database and application logic declaring CRUD methods for Address objects
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
