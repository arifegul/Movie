package com.example.movies.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.movies.api.dbo.MovieResponse;
import com.example.movies.persistance.entity.Movie;
import com.example.movies.service.MovieService;


@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/import")
    public ResponseEntity<?> importCSV(@RequestParam("file") MultipartFile file){
        return new ResponseEntity<String>(movieService.importCSV(file), HttpStatus.CREATED);
    }

    @PostMapping("/createMovie")
    public ResponseEntity<MovieResponse> createMovie(@RequestBody Movie movie) {
        return new ResponseEntity<MovieResponse>(movieService.createMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        return new ResponseEntity<List<MovieResponse>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/getMovieById/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable String id) {
        return new ResponseEntity<MovieResponse>(movieService.getMovieById(id), HttpStatus.OK);
    } 
}
