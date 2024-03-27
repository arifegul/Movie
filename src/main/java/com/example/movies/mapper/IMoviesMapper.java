package com.example.movies.mapper;

import org.mapstruct.Mapper;

import com.example.movies.api.dbo.MovieResponse;
import com.example.movies.api.dbo.ReviewResponse;
import com.example.movies.api.dbo.RoleResponse;
import com.example.movies.api.dbo.UserResponse;
import com.example.movies.persistance.entity.Movie;
import com.example.movies.persistance.entity.Review;
import com.example.movies.persistance.entity.Role;
import com.example.movies.persistance.entity.User;

@Mapper
public interface IMoviesMapper {
    Movie dtoToEntity(MovieResponse movieResponse);
    MovieResponse entityToDto(Movie movie);

    ReviewResponse entityToDto(Review review);

    UserResponse entityToDto(User user);

    RoleResponse entityToDto(Role role);
}
