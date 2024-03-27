package com.example.movies.persistance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.movies.persistance.entity.Movie;


@Repository
public interface MovieRepository extends MongoRepository<Movie,String>{
}


