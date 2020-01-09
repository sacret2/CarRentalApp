package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.api.request.AddRentalRequest;
import com.mkcomp.CarRentalApp.model.Damage;
import com.mkcomp.CarRentalApp.model.Rental;
import com.mkcomp.CarRentalApp.model.Reservation;
import com.mkcomp.CarRentalApp.repository.DamageRepository;
import com.mkcomp.CarRentalApp.repository.RentalRepository;
import com.mkcomp.CarRentalApp.service.RentalService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * Service layer class defining CRUD operations on Rental objects
 */
@Service
public class RentalServiceImpl implements RentalService {
    private RentalRepository rentalRepository;
    private DamageRepository damageRepository;

    public RentalServiceImpl(RentalRepository rentalRepository, DamageRepository damageRepository) {
        this.rentalRepository = rentalRepository;
        this.damageRepository = damageRepository;
    }

    /**
     * Additionally saves a Damage object associated with the Rental being saved
     */
    @Override
    public Long addRental(AddRentalRequest request, Reservation reservation) {
        Rental rental = new Rental();
        rental.setOverduePenalty(request.getOverduePenalty());
        rental.setReservation(reservation);
        LocalDateTime returnDate = request.getReturnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        rental.setReturnDate(returnDate);
        rental.setWasOverdue(request.isWasOverdue());
        Damage damage = new Damage();
        damageRepository.save(damage);
        rental.setDamage(damage);
        rentalRepository.save(rental);
        System.out.println(rental);
        return rental.getId();
    }

    @Override
    public List<Rental> getAllRentals(long customerId) {
        return rentalRepository.findAll();  // TO BE IMPLEMENTED
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental getRental(long rentalId) {
        return rentalRepository.getOne(rentalId);
    }
}
