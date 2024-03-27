package com.example.movies.persistance.entity;

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
@Document(collection = "Role")
public class Role extends BaseEntity{
    private String name;
}
