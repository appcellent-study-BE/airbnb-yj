package com.example.airbnb_clonecoding.service;

import com.example.airbnb_clonecoding.dto.ReviewDto;
import com.example.airbnb_clonecoding.model.Member;
import com.example.airbnb_clonecoding.model.Reservation;
import com.example.airbnb_clonecoding.model.Review;
import com.example.airbnb_clonecoding.model.Room;
import com.example.airbnb_clonecoding.repository.ReservationRepository;
import com.example.airbnb_clonecoding.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {

    private final ReservationRepository reservationRepository;
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository, ReservationRepository reservationRepository) {

        this.reservationRepository = reservationRepository;
        this.reviewRepository = reviewRepository;
    }

    public void writeReview(ReviewDto reviewDto) {

        // 예약 정보 조회
        Reservation reservation = reservationRepository.findById(reviewDto.getReservationId())
                .orElseThrow(() -> new IllegalArgumentException("No Reservation"));

        // 리뷰 생성
        Review review = Review.builder()
                .userId(reservation.getUserId())
                .roomId(reservation.getRoomId())
                .reservationId(reservation)
                .reviewDate(LocalDateTime.now())
                .review(reviewDto.getReview())
                .rating(reviewDto.getRating())
                .ratingClean(reviewDto.getRatingClean())
                .ratingAccuracy(reviewDto.getRatingAccuracy())
                .ratingCheckIn(reviewDto.getRatingCheckIn())
                .ratingCommunication(reviewDto.getRatingCommunication())
                .ratingLocation(reviewDto.getRatingLocation())
                .ratingPrice(reviewDto.getRatingPrice())
                .build();

        reviewRepository.save(review);
    }

}