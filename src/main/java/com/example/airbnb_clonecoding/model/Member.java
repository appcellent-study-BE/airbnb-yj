package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;

@Entity

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
}
