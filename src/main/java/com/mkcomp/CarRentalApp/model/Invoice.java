package com.mkcomp.CarRentalApp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private LocalDateTime issueDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rental_id")
    private Rental rental;

}
