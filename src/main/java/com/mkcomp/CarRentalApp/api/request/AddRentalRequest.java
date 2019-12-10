package com.mkcomp.CarRentalApp.api.request;

import com.mkcomp.CarRentalApp.model.Damage;
import com.mkcomp.CarRentalApp.model.Reservation;

import java.time.LocalDateTime;

public class AddRentalRequest {

    private boolean wasOverdue;
    private double overduePenalty;
    private LocalDateTime returnDate;
    private Reservation reservation;
    private AddDamageRequest damageRequest;

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public AddDamageRequest getDamageRequest() {
        return damageRequest;
    }

    public void setDamageRequest(AddDamageRequest damageRequest) {
        this.damageRequest = damageRequest;
    }

    public boolean isWasOverdue() {
        return wasOverdue;
    }

    public void setWasOverdue(boolean wasOverdue) {
        this.wasOverdue = wasOverdue;
    }

    public double getOverduePenalty() {
        return overduePenalty;
    }

    public void setOverduePenalty(double overduePenalty) {
        this.overduePenalty = overduePenalty;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
