package com.example.movies.persistance.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.movies.persistance.entity.baseEntity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class User extends BaseEntity {
    private String userName;
    private String password;
    private String email;
    private List<String> roleIds;
}
