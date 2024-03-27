package com.example.movies.api.dbo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
    private String id;
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
    private List<ReviewResponse> reviews;
    private Boolean status;
}
