package com.example.airbnb_clonecoding.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
public class RoomDto {

    private int hostId;             // 호스트 ID
    private String roomName;        // 숙소 이름
    private String roomDscrptn;     // 숙소 설명
    private String roomAddress;     // 숙소 주소
    private String roomLocation;    // 숙소 위치에 대한 설명
    private int roomAdultMax;       // 최대 성인 인원
    private int roomChildMax;       // 최대 어린이 인원
    private int roomPetMax;         // 최대 반려동물 수
    private int bedroomNum;         // 침실 개수
    private int bathroomNum;        // 욕실 개수
    private BigDecimal roomPrice;   // 숙소 가격
    private LocalTime checkInTime;  // 체크인 시간
    private LocalTime checkOutTime; // 체크아웃 시간
}