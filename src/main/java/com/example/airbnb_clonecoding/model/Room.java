package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private Long roomId;

    @ManyToOne
    private Host hostId;

    private String roomName;

    private String roomDscrptn;

    private String roomAddress;

    private String roomLocation;

    private int roomAdultMax;

    private int roomChildrenMax;

    private int roomPetMax;

    private int bedroomNum;

    private int bathroomNum;

    private float roomPrice;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;
}