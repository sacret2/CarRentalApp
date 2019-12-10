package com.mkcomp.CarRentalApp.api.request;

import com.mkcomp.CarRentalApp.model.Car;
import com.mkcomp.CarRentalApp.model.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;

public class AddReservationRequest {
    private LocalDateTime reservationDate;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    private Car car;
    private Customer customer;
    private double cost;

    public AddReservationRequest() {
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(LocalDateTime reservationStart) {
        this.reservationStart = reservationStart;
    }

    public LocalDateTime getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(LocalDateTime reservationEnd) {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
