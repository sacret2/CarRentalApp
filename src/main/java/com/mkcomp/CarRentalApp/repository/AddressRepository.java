package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
