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
@Document(collection = "Review")
public class Review extends BaseEntity{
    private String review;
    private String movieId;
}
