package com.example.movies.persistance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.movies.persistance.entity.User;

public interface UserRepository extends MongoRepository<User,String> {
    
}
