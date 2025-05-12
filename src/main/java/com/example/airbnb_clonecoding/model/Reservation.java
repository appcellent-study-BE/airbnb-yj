package com.example.airbnb_clonecoding.model;

import com.example.airbnb_clonecoding.model.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private int reservationId;

    @ManyToOne
    private Member userId;

    @ManyToOne
    private Room roomId;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private ReservationStatus status;

    private int adults;

    private int children;

    private int infants;

    private int pets;
}