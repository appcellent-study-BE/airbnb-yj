package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRIP_ID")
    private int tripId;

    @OneToOne
    private Reservation reservationId;
}