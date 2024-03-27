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
@Document(collection = "Movie")
public class Movie extends BaseEntity {
    private String name;
    private String rating;
    private String genre;
    private Integer year;
    private String released;
    private Double score;
    private Double votes;
    private String director;
    private String writer;
    private String star;
    private String country;
    private Double budget;
    private Double gross;
    private String company;
    private Double runtime;
}