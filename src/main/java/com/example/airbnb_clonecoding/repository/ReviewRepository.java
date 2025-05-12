package com.example.airbnb_clonecoding.repository;

import com.example.airbnb_clonecoding.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}