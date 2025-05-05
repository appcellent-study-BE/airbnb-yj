package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    private String userName;

    private String userLoginId;

    private String userPassword;

    private String userEmail;

    private String userPhoneNum;

    private LocalDate userDOB;

    private boolean isHost;

    private LocalDate registerDate;

    private Enum userGender;

    private boolean isCertificate;
}