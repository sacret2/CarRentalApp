package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.api.request.AddReservationRequest;
import com.mkcomp.CarRentalApp.model.Reservation;
import com.mkcomp.CarRentalApp.repository.ReservationRepository;
import com.mkcomp.CarRentalApp.service.ReservationService;

import java.util.List;
import java.util.Set;

public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Long addReservation(AddReservationRequest request) {
        return null;
    }

    @Override
    public Set<Reservation> getAllReservations(long customerId) {
        return null;
    }

    @Override
    public boolean deleteReservation(long reservationId) {
        return false;
    }

    @Override
    public boolean makeAnAdvancePayment(long reservationId) {
        return false;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.getOne(id);
    }
}