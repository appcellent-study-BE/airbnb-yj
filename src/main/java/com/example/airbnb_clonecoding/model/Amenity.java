package com.example.airbnb_clonecoding.model;

import com.example.airbnb_clonecoding.model.enums.AmenityCategory;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Amenity_ID")
    private int amenityId;

    private AmenityCategory amenityCategory;

    @Column(length = 50)
    private String amenity;
}