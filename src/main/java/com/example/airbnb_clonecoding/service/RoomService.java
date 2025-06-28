package com.example.airbnb_clonecoding.service;

import com.example.airbnb_clonecoding.dto.RoomDto;
import com.example.airbnb_clonecoding.dto.ReviewDto;
import com.example.airbnb_clonecoding.model.Room;
import com.example.airbnb_clonecoding.model.Review;
import com.example.airbnb_clonecoding.repository.RoomRepository;
import com.example.airbnb_clonecoding.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final ReviewRepository reviewRepository;

    public RoomService(RoomRepository roomRepository, ReviewRepository reviewRepository) {
        this.roomRepository = roomRepository;
        this.reviewRepository = reviewRepository;
    }

    public RoomDto roomDetail(int roomId) {
        // 숙소 정보 조회
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("No room"));

        // 숙소 리뷰 조회
        List<Review> reviews = reviewRepository.findByRoomId_RoomId(roomId);

        // 평균 평점 계산
        Map<String, Float> ratings = new HashMap<>();

        if (!reviews.isEmpty()) {
            float averageRating = (float) reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0);
            float ratingClean = (float) reviews.stream().mapToDouble(Review::getRatingClean).average().orElse(0.0);
            float ratingAccuracy = (float) reviews.stream().mapToDouble(Review::getRatingAccuracy).average().orElse(0.0);
            float ratingCheckin = (float) reviews.stream().mapToDouble(Review::getRatingCheckIn).average().orElse(0.0);
            float ratingCommunication = (float) reviews.stream().mapToDouble(Review::getRatingCommunication).average().orElse(0.0);
            float ratingLocation = (float) reviews.stream().mapToDouble(Review::getRatingLocation).average().orElse(0.0);
            float ratingPrice = (float) reviews.stream().mapToDouble(Review::getRatingPrice).average().orElse(0.0);

            ratings.put("averageRating", averageRating);
            ratings.put("ratingClean", ratingClean);
            ratings.put("ratingAccuracy", ratingAccuracy);
            ratings.put("ratingCheckin", ratingCheckin);
            ratings.put("ratingCommunication", ratingCommunication);
            ratings.put("ratingLocation", ratingLocation);
            ratings.put("ratingPrice", ratingPrice);
        }

        // 리뷰
        List<ReviewDto> reviewList = reviews.stream().map(review -> {
            ReviewDto dto = new ReviewDto();
            dto.setReservationId(review.getReservationId().getReservationId());
            dto.setReview(review.getReview());
            dto.setRating(review.getRating());
            dto.setRatingClean(review.getRatingAccuracy());
            dto.setRatingAccuracy(review.getRatingCheckIn());
            dto.setRatingCheckIn(review.getRatingCommunication());
            dto.setRatingLocation(review.getRatingLocation());
            dto.setRatingPrice(review.getRatingPrice());
            return dto;
        }).collect(Collectors.toList());

        // 숙소 정보
        return RoomDto.builder()
                .roomId(room.getRoomId())
                .roomName(room.getRoomName())
                .capacityMax(room.getRoomAdultMax() + room.getRoomChildrenMax())
                .petMax(room.getRoomPetMax())
                .bedroomNum(room.getBedroomNum())
                .bathroomNum(room.getBathroomNum())
                .roomDscrptn(room.getRoomDscrptn())
                .roomAddress(room.getRoomAddress())
                .roomLocation(room.getRoomLocation())
                .ratings(ratings)
                .reviews(reviewList)
                .build();
    }
}