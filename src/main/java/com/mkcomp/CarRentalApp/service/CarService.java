package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddCarRequest;

public interface CarService {

    Long addCar(AddCarRequest request);
}
