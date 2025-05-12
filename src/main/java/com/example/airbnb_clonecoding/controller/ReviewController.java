package com.example.airbnb_clonecoding.controller;

import com.example.airbnb_clonecoding.dto.ResponseDto;
import com.example.airbnb_clonecoding.dto.ReviewDto;
import com.example.airbnb_clonecoding.service.ReviewService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {

        this.reviewService = reviewService;
    }

    @PostMapping("/write-review")
    public ResponseDto<Object> writeReview(@RequestBody ReviewDto reviewDto) {

        System.out.println("review: " + reviewDto.getReview());

        reviewService.writeReview(reviewDto);

        return ResponseDto.success("review success", null);
    }

}