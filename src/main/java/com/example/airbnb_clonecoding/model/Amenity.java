package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;

@Entity
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Amenity_ID")
    private Long amenityId;

    private Enum amenityCategory;

    private String amenity;
}