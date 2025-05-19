package com.example.airbnb_clonecoding.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDto {

    private int userId;
    private LocalDateTime checkInDate;  // 체크인 시간
    private LocalDateTime checkOutDate; // 체크아웃 시간
    private int adults;                 // 예약 성인 인원
    private int children;               // 예약 어린이 인원
    private int infants;                // 예약 유아 인원
    private int pets;                   // 반려동물
}