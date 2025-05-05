package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOST_ID")
    private Long hostId;

    @OneToOne
    private Member userId;

    private LocalDate hostDate;

    private boolean isEmail;

    private boolean isPhoneNum;
}