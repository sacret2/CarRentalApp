package com.mkcomp.CarRentalApp.api.request;

import com.mkcomp.CarRentalApp.model.Branch;


public class AddCarRequest {
    private long carId;
    private String brand;
    private String model;
    private int productionYear;
    private String specification;
    private double basePricePerDay;
    private long branchId;

    public AddCarRequest() {
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public AddCarRequest(String brand, String model, int productionYear, String specification, double basePricePerDay, long branchId) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.specification = specification;
        this.basePricePerDay = basePricePerDay;
        this.branchId = branchId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }
}
