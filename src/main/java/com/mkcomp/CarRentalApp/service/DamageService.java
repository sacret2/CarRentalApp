package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddCarRequest;
import com.mkcomp.CarRentalApp.model.Car;
import com.mkcomp.CarRentalApp.model.Damage;

import java.util.List;

/**
 * Service layer class for CRUD operations on Damage objects
 */
public interface DamageService {
    Long saveDamage(Damage damage);
    List<Damage> findAll();
    Damage findDamageById(Long id);
}
