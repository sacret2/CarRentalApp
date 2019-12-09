package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageRepository extends JpaRepository<Damage, Long> {
}
