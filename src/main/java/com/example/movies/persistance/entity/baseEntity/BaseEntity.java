package com.example.movies.persistance.entity.baseEntity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "BaseEntity")
public abstract class BaseEntity {
    @Id
    @Generated
    private String id;
    private Boolean status;
}
