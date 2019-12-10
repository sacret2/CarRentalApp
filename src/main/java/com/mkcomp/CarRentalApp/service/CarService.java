package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddCarRequest;
import com.mkcomp.CarRentalApp.model.Car;

import java.util.List;

public interface CarService {

    Long addCar(AddCarRequest request);
    List<Car> findAll();
    void deleteCarById(long id);
    Car findCarById(Long id);
}
