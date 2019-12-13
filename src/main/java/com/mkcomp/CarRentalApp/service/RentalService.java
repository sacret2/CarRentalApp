package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddRentalRequest;
import com.mkcomp.CarRentalApp.model.Rental;

import java.util.List;

/**
 * Service layer class for CRUD operations on Rental objects
 */
public interface RentalService {

    Long addRental(AddRentalRequest request);
    List<Rental> getAllRentals(long customerId);
    List<Rental> getAllRentals();
    Rental getRental(long rentalId);
}
