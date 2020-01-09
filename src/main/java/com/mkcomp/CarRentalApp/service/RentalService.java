package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddRentalRequest;
import com.mkcomp.CarRentalApp.model.Rental;
import com.mkcomp.CarRentalApp.model.Reservation;

import java.util.List;

/**
 * Service layer interface declaring CRUD operations on Rental objects
 */
public interface RentalService {

    Long addRental(AddRentalRequest request, Reservation reservation);
    List<Rental> getAllRentals(long customerId);
    List<Rental> getAllRentals();
    Rental getRental(long rentalId);
}
