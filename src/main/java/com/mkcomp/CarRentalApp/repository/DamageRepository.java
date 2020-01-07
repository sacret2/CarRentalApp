package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface between Postgres database and application logic declaring CRUD methods for Damage objects.
 * Those methods are implemented by Hibernate, providing access to database from java code in Service objects..
 */
public interface DamageRepository extends JpaRepository<Damage, Long> {
}
