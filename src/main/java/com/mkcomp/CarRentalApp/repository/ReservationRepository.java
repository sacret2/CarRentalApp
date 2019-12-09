package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
