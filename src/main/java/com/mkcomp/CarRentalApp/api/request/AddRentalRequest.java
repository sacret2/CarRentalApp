package com.mkcomp.CarRentalApp.api.request;

import com.mkcomp.CarRentalApp.model.Reservation;
import com.mkcomp.CarRentalApp.model.Damage;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Class used as data wrapper for Rental requests
 */
public class AddRentalRequest {

    private boolean wasOverdue;
    private double overduePenalty;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;
    private Reservation reservation;

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
