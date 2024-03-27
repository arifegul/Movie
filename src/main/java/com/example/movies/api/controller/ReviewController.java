package com.example.movies.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.movies.api.dbo.ReviewResponse;
import com.example.movies.persistance.entity.Review;
import com.example.movies.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/createReview")
    public ResponseEntity<ReviewResponse> createReview(@RequestBody Review review){
        return new ResponseEntity<ReviewResponse>(reviewService.creatReview(review), HttpStatus.CREATED);
    }
    @GetMapping("/getReviewsByMovieId/{id}")
    public ResponseEntity<List<ReviewResponse>> getReviewsByMovieId(String id){
        return new ResponseEntity<List<ReviewResponse>>(reviewService.getReviewsByMovieId(id), HttpStatus.OK);
    }
}
