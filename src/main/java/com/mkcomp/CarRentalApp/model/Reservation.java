package com.mkcomp.CarRentalApp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private LocalDateTime reservationDate;

    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private double cost;
    private double advancePayment;
    private boolean wasAdvancePaid;

}
