package com.example.airbnb_clonecoding.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
public class RoomDto {

    private int hostId;
    private String roomName;
    private String roomDscrptn;
    private String roomAddress;
    private String roomLocation;
    private int roomAdultMax;
    private int roomChildMax;
    private int roomPetMax;
    private int bedroomNum;
    private int bathroomNum;
    private BigDecimal roomPrice;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
}