package com.example.movies.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movies.persistance.entity.Role;
import com.example.movies.persistance.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public Role createRole(Role role){
        Role response = repository.save(role);
        
        return response;
    }
}
