package com.mkcomp.CarRentalApp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private boolean wasOverdue;
    private double overduePenalty;
    private LocalDateTime returnDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "damage_id")
    private Damage damage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;


}
