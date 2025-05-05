package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long reviewId;

    @ManyToOne
    private Room roomId;

    @ManyToOne
    private Member userId;

    @OneToOne
    private Reservation reservationId;

    private float averageRating;

    private String review;

    private LocalDateTime reviewDate;

    private float ratingClean;

    private float ratingAccuracy;

    private float ratingCheckIn;

    private float ratingConversation;

    private float ratingLocation;

    private float ratingPrice;
}