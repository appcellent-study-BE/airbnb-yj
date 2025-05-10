package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private int reviewId;

    @ManyToOne
    private Room roomId;

    @ManyToOne
    private Member userId;

    @OneToOne
    private Reservation reservationId;

    @Column(length = 500)
    private String review;

    private LocalDateTime reviewDate;

    private float rating;

    private float ratingClean;

    private float ratingAccuracy;

    private float ratingCheckIn;

    private float ratingCommunication;

    private float ratingLocation;

    private float ratingPrice;
}