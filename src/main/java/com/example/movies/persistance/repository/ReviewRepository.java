package com.example.movies.persistance.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.movies.persistance.entity.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review,String>{
    List<Review> findByMovieId(String movieId);
}
