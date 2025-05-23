package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class RoomAmenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_AMENITY_ID")
    private int roomAmenityId;

    @OneToOne
    private Room roomId;

    @ManyToOne
    private Amenity amenityId;

    private boolean isAmenity;
}