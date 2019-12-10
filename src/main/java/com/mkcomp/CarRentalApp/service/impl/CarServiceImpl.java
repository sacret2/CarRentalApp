package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.api.request.AddCarRequest;
import com.mkcomp.CarRentalApp.model.Branch;
import com.mkcomp.CarRentalApp.model.Car;
import com.mkcomp.CarRentalApp.repository.BranchRepository;
import com.mkcomp.CarRentalApp.repository.CarRepository;
import com.mkcomp.CarRentalApp.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    private BranchRepository branchRepository;

    public CarServiceImpl(CarRepository carRepository, BranchRepository branchRepository) {
        this.carRepository = carRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Long addCar(AddCarRequest request) {
        Branch branch = extractBranchFromRepository(request.getBranchId());
        Car car = addCarToDataSource(request, branch);
        return car.getId();
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }

    private Branch extractBranchFromRepository(Long branchId) {
        Optional<Branch> optionalBranch = branchRepository.findById(branchId);
        if (!optionalBranch.isPresent()) {
            throw new IllegalArgumentException("There is no such a branch within database");
        }
        return optionalBranch.get();
    }

    private Car addCarToDataSource(AddCarRequest request, Branch branch){
        Car car = new Car();
        car.setBasePricePerDay(request.getBasePricePerDay());
        car.setBrand(request.getBrand());
        car.setBranch(branch);
        car.setModel(request.getModel());
        car.setProductionYear(request.getProductionYear());
        car.setSpecification(request.getSpecification());
        return carRepository.save(car);
    }



}
