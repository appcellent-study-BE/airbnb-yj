package com.example.airbnb_clonecoding.repository;

import com.example.airbnb_clonecoding.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByRoomId_RoomId(int roomId);
}