package com.example.movies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.api.dbo.RoleResponse;
import com.example.movies.api.dbo.UserResponse;
import com.example.movies.mapper.IMoviesMapper;
import com.example.movies.persistance.entity.User;
import com.example.movies.persistance.repository.RoleRepository;
import com.example.movies.persistance.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    @Autowired
    private IMoviesMapper mapper;
    @Autowired
    private RoleRepository roleRepository;

    public User createUser(User user){
        var response = repository.save(user);

        return response;
    }

    public List<UserResponse> getAllUser(){
        var getUsers = repository.findAll();

        List<UserResponse> response = new ArrayList<>();
        getUsers.forEach(getUser -> {
            var mapUser = mapper.entityToDto(getUser);

            var getUserRoles = roleRepository.findAllById(getUser.getRoleIds());

            List<RoleResponse> roleResponse = new ArrayList<>();
            getUserRoles.forEach(role -> {
                var getRoleResponse = mapper.entityToDto(role);

                roleResponse.add(getRoleResponse);
            });

            mapUser.setRoles(roleResponse);

            response.add(mapUser);
        });

        return response;
    }
}
