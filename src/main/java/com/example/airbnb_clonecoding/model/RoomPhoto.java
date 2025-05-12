package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class RoomPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHOTO_ID")
    private int photoId;

    @OneToOne
    private Room roomId;

    @Column(columnDefinition = "TEXT")
    private String roomPhotoUrl;
}