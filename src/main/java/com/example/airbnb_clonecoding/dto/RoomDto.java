package com.example.airbnb_clonecoding.dto;

import lombok.*;

import java.util.Map;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private int roomId;
    private String roomName;
    private int capacityMax;    // roomAdultMax + roomChildrenMax
    private int petMax;
    private int bedroomNum;
    private int bathroomNum;
    private String roomDscrptn;
    private String roomAddress;
    private String roomLocation;

    private Map<String, Float> ratings;
    private List<ReviewDto> reviews;
}
