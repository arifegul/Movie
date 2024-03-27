package com.example.movies.persistance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.movies.persistance.entity.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role,String>{
}
