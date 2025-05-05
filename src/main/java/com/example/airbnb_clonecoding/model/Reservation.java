package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long reservationId;

    @ManyToOne
    private Member userId;

    @ManyToOne
    private Room roomId;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private String status;

    private int adults;

    private int children;

    private int infants;

    private int pets;
}