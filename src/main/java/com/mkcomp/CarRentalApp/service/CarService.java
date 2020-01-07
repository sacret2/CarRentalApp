package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddCarRequest;
import com.mkcomp.CarRentalApp.model.Car;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Service layer interface declaring CRUD operations on Car objects
 */
public interface CarService {

    Long addCar(AddCarRequest request);
    List<Car> findAll();
    void deleteCarById(long id);
    Car findCarById(Long id);
    List<Car> findAvailableCars(LocalDateTime startDate, LocalDateTime endDate, long branchId);
    void updateCar(AddCarRequest request, long id);
}
