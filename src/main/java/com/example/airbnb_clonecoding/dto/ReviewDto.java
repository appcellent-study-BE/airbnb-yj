package com.example.airbnb_clonecoding.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {

    private int reservationId;          // 예약 번호
    private String review;              // 후기 내용
    private float rating;               // 별점
    private float ratingClean;          // 청결도
    private float ratingAccuracy;       // 정확도
    private float ratingCheckIn;        // 체크인
    private float ratingCommunication;  // 의사소통
    private float ratingLocation;       // 위치
    private float ratingPrice;          // 가성비
}