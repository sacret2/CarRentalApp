package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddReservationRequest;
import com.mkcomp.CarRentalApp.model.Customer;
import com.mkcomp.CarRentalApp.model.Reservation;

import java.util.List;
import java.util.Set;

public interface ReservationService {

    Long addReservation(AddReservationRequest request);
    Set<Reservation> getAllReservations(long customerId);
    boolean deleteReservation(long reservationId);
    boolean makeAnAdvancePayment(long reservationId);
    List<Reservation> findAll();
    Reservation findById(Long id);
    Long addReservation(Reservation reservation);
    List<Reservation> findReservationsByCustomer(Customer customer);

}
