package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.api.request.AddCarRequest;
import com.mkcomp.CarRentalApp.model.Damage;
import com.mkcomp.CarRentalApp.repository.DamageRepository;
import org.springframework.stereotype.Service;
import com.mkcomp.CarRentalApp.service.DamageService;

import javax.persistence.OneToOne;
import java.util.List;

/**
 * Service layer class defining CRUD operations on Damage objects
 */
@Service
public class DamageServiceImpl implements DamageService {
    DamageRepository damageRepository;

    @Override
    public Long saveDamage(Damage damage) {
        damageRepository.save(damage);
        return damage.getId();
    }

    @Override
    public List<Damage> findAll() {
        return damageRepository.findAll();
    }

    @Override
    public Damage findDamageById(Long id) {
        return damageRepository.getOne(id);
    }
}
