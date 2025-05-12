package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private Long roomId;

    @ManyToOne
    private Host hostId;

    @Column(length = 50)
    private String roomName;

    @Column(columnDefinition = "TEXT")
    private String roomDscrptn;

    @Column(length = 150)
    private String roomAddress;

    @Column(length = 500)
    private String roomLocation;

    private int roomAdultMax;

    private int roomChildrenMax;

    private int roomPetMax;

    private int bedroomNum;

    private int bathroomNum;

    @Column(precision = 10, scale = 2)
    private BigDecimal roomPrice;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;
}