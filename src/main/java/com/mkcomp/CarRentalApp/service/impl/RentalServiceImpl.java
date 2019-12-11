package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.api.request.AddRentalRequest;
import com.mkcomp.CarRentalApp.model.Damage;
import com.mkcomp.CarRentalApp.model.Rental;
import com.mkcomp.CarRentalApp.repository.DamageRepository;
import com.mkcomp.CarRentalApp.repository.RentalRepository;
import com.mkcomp.CarRentalApp.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {
    private RentalRepository rentalRepository;
    private DamageRepository damageRepository;

    public RentalServiceImpl(RentalRepository rentalRepository, DamageRepository damageRepository) {
        this.rentalRepository = rentalRepository;
        this.damageRepository = damageRepository;
    }

    @Override
    public Long addRental(AddRentalRequest request) {
        Rental rental = new Rental();
        rental.setOverduePenalty(request.getOverduePenalty());
        rental.setReservation(request.getReservation());
        rental.setReturnDate(request.getReturnDate());
        rental.setWasOverdue(request.isWasOverdue());
        Damage damage = new Damage();
        damageRepository.save(new Damage());
        rental.setDamage(damage);
        rentalRepository.save(rental);
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
