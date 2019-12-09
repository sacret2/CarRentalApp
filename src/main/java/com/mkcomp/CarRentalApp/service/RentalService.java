package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddRentalRequest;
import com.mkcomp.CarRentalApp.model.Rental;

import java.util.Set;

public interface RentalService {

    Long addRental(AddRentalRequest request);
    Set<Rental> getAllRentals(long customerId);
    Rental getRental(long rentalId);

}
