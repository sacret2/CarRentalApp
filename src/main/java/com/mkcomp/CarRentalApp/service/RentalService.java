package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddRentalRequest;
import com.mkcomp.CarRentalApp.model.Rental;

import java.util.List;

public interface RentalService {

    Long addRental(AddRentalRequest request);
    List<Rental> getAllRentals(long customerId);
    List<Rental> getAllRentals();
    Rental getRental(long rentalId);
}
