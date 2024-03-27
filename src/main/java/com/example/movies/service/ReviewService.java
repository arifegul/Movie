package com.example.movies.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movies.api.dbo.ReviewResponse;
import com.example.movies.mapper.IMoviesMapper;
import com.example.movies.persistance.entity.Review;
import com.example.movies.persistance.repository.ReviewRepository;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository repository;
    @Autowired
    private IMoviesMapper mapper;

    public ReviewResponse creatReview(Review review){

        Review createdReview = repository.save(review);

        ReviewResponse response = mapper.entityToDto(createdReview);

        return response;
    }

    public List<ReviewResponse> getReviewsByMovieId(String movieId){

        List<Review> getReviews = repository.findByMovieId(movieId);

        List<ReviewResponse> response = new ArrayList<>();

        getReviews.forEach(review -> {
            response.add(mapper.entityToDto(review));
        });

        return response;
    }
}
