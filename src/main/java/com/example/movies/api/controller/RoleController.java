package com.example.movies.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.persistance.entity.Role;
import com.example.movies.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    
    @Autowired 
    private RoleService roleService;

    @PostMapping("createRole")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return new ResponseEntity<Role>(roleService.createRole(role), HttpStatus.CREATED);
    }
}
