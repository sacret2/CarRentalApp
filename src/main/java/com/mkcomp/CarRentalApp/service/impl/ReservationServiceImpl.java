package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.api.request.AddReservationRequest;
import com.mkcomp.CarRentalApp.model.Customer;
import com.mkcomp.CarRentalApp.model.Reservation;
import com.mkcomp.CarRentalApp.repository.ReservationRepository;
import com.mkcomp.CarRentalApp.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Service layer class defining CRUD operations on Reservation objects
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Long addReservation(AddReservationRequest request) {
        Reservation newReservation = new Reservation();
        newReservation.setCar(request.getCar());
        newReservation.setCost(request.getCost());
        newReservation.setCustomer(request.getCustomer());
        newReservation.setReservationDate(request.getReservationDate());
        newReservation.setReservationEnd(request.getReservationEnd());
        newReservation.setReservationStart(request.getReservationStart());
        return reservationRepository.save(newReservation).getId();
    }

    @Override
    public Set<Reservation> getAllReservations(long customerId) {
        return new HashSet<Reservation>(reservationRepository.findAll());
    }

    @Override
    public void deleteReservation(long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.getOne(id);
    }

    @Override
    public Long addReservation(Reservation reservation) {
        return reservationRepository.save(reservation).getId();
    }

    @Override
    public List<Reservation> findReservationsByCustomer(Customer customer) {
        return reservationRepository.findAllByCustomerIs(customer);
    }
}
