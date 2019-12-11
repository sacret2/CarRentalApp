package com.mkcomp.CarRentalApp.api.request;

import com.mkcomp.CarRentalApp.model.Car;
import com.mkcomp.CarRentalApp.model.Customer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

public class AddReservationRequest {

    private LocalDateTime reservationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reservationStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reservationEnd;
    private Car car;
    private Customer customer;
    private long branchId;
    private double cost;

    public AddReservationRequest() {
        this.reservationDate = LocalDateTime.now();
    }

    public AddReservationRequest(Car car, Customer customer) {
        this();
        this.car = car;
        this.customer = customer;
    }

    private LocalDateTime parse(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            return (LocalDateTime) formatter.parse(dateString);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(Date reservationStart) {
        this.reservationStart = reservationStart;
    }

    public Date getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(Date reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getBranchId() {
        return branchId;
    }


    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void calculateAndSaveCost() {
        //this.cost = this.car.getBasePricePerDay() * TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS))this.reservationEnd;

    }

}
