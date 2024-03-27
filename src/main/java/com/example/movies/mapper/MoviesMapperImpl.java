package com.example.movies.mapper;

import org.springframework.stereotype.Component;

import com.example.movies.api.dbo.MovieResponse;
import com.example.movies.api.dbo.ReviewResponse;
import com.example.movies.api.dbo.RoleResponse;
import com.example.movies.api.dbo.UserResponse;
import com.example.movies.persistance.entity.Movie;
import com.example.movies.persistance.entity.Review;
import com.example.movies.persistance.entity.Role;
import com.example.movies.persistance.entity.User;

@Component
public class MoviesMapperImpl implements IMoviesMapper {

    @Override
    public Movie dtoToEntity(MovieResponse movieResponse) {
        if(movieResponse == null)
            return null;

        Movie movie = new Movie();

        movie.setId(movieResponse.getId());
        movie.setStatus(movieResponse.getStatus());
        movie.setName(movieResponse.getName());
        movie.setRating(movieResponse.getRating());
        movie.setGenre(movieResponse.getGenre());
        movie.setYear(movieResponse.getYear());
        movie.setReleased(movieResponse.getReleased());
        movie.setScore(movieResponse.getScore());
        movie.setVotes(movieResponse.getVotes());
        movie.setDirector(movieResponse.getDirector());
        movie.setWriter(movieResponse.getWriter());
        movie.setStar(movieResponse.getStar());
        movie.setCountry(movieResponse.getCountry());
        movie.setBudget(movieResponse.getBudget());
        movie.setGross(movieResponse.getGross());
        movie.setCompany(movieResponse.getCompany());
        movie.setRuntime(movieResponse.getRuntime());

        return movie;
    }

    @Override
    public MovieResponse entityToDto(Movie movie) {
         if(movie == null)
            return null;

        MovieResponse movieResponse = new MovieResponse();

        movieResponse.setId(movie.getId());
        movieResponse.setStatus(movie.getStatus());
        movieResponse.setName(movie.getName());
        movieResponse.setRating(movie.getRating());
        movieResponse.setGenre(movie.getGenre());
        movieResponse.setYear(movie.getYear());
        movieResponse.setReleased(movie.getReleased());
        movieResponse.setScore(movie.getScore());
        movieResponse.setVotes(movie.getVotes());
        movieResponse.setDirector(movie.getDirector());
        movieResponse.setWriter(movie.getWriter());
        movieResponse.setStar(movie.getStar());
        movieResponse.setCountry(movie.getCountry());
        movieResponse.setBudget(movie.getBudget());
        movieResponse.setGross(movie.getGross());
        movieResponse.setCompany(movie.getCompany());
        movieResponse.setRuntime(movie.getRuntime());
        
        return movieResponse;
    }

    @Override
    public ReviewResponse entityToDto(Review review) {
        if(review == null)
            return null;

        ReviewResponse reviewResponse = new ReviewResponse();

        reviewResponse.setId(review.getId());
        reviewResponse.setReview(review.getReview());
        reviewResponse.setStatus(review.getStatus());

        return reviewResponse;
    }

    @Override
    public UserResponse entityToDto(User user) {
        if(user == null)
            return null;

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setUserName(user.getUserName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setStatus(user.getStatus());

        return userResponse;
    }

    @Override
    public RoleResponse entityToDto(Role role) {
        if(role == null)
            return null;

        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setId(role.getId());
        roleResponse.setName(role.getName());
        roleResponse.setStatus(role.getStatus());

        return roleResponse;
    }

}
