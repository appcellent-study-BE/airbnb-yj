package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;

@Entity

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long reservationId;

    @ManyToOne
    private Member userId;
}
