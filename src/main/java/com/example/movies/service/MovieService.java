package com.example.movies.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.movies.api.dbo.MovieResponse;
import com.example.movies.mapper.IMoviesMapper;
import com.example.movies.persistance.entity.Movie;
import com.example.movies.persistance.repository.MovieRepository;

@Service
public class MovieService {
 
    @Autowired
    private MovieRepository repository;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private IMoviesMapper mapper;

    public String importCSV(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            String line;
            boolean headerSkipped = false;

            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    // İlk satırı atlayalım
                    headerSkipped = true;
                    continue;
                }

                List<String> fields = parseCSVLine(line);

                // fields dizisini kullanarak Movie nesnesini oluşturalım
                Movie movie = new Movie();

                movie.setName(fields.get(0));
                movie.setRating(fields.get(1));
                movie.setGenre(fields.get(2));
                String yearString = fields.get(3);
                int year = 0; // Default değer sıfır olarak ayarlandı           
                if (yearString != null && !yearString.isEmpty()) {
                    year = Integer.parseInt(yearString);
                } 
                movie.setYear(year);
                movie.setReleased(fields.get(5));
                String scoreString = fields.get(6);
                double score = 0.0;       
                if (scoreString != null && !scoreString.isEmpty()) {
                    score = Double.parseDouble(scoreString);
                } 
                movie.setScore(score);
                String votesString = fields.get(7);
                double votes = 0.0;          
                if (votesString != null && !votesString.isEmpty()) {
                    votes = Double.parseDouble(votesString);
                } 
                movie.setVotes(votes);
                movie.setDirector(fields.get(8));
                movie.setWriter(fields.get(9));
                movie.setStar(fields.get(10));
                movie.setCountry(fields.get(11));
                String budgetString = fields.get(12);
                double budget = 0.0;        
                if (budgetString != null && !budgetString.isEmpty()) {
                    budget = Double.parseDouble(budgetString);
                }     
                movie.setBudget(budget);
                String grossString = fields.get(13);
                double gross = 0.0;          
                if (grossString != null && !grossString.isEmpty()) {
                    gross = Double.parseDouble(grossString);
                } 
                movie.setGross(gross);
                movie.setCompany(fields.get(14));
                String runtimeString = fields.get(15);
                double runtime = 0.0;         
                if (runtimeString != null && !runtimeString.isEmpty()) {
                    runtime = Double.parseDouble(runtimeString);
                } 
                movie.setRuntime(runtime);

                repository.save(movie);
            }

            return "CSV data imported successfully";
        } catch (IOException e) {
            return "Error importing CSV data: " + e.getMessage();
        }
    }

    private List<String> parseCSVLine(String line) {
        List<String> fields = new ArrayList<>();
        
        Pattern pattern = Pattern.compile("(?<=,|^)\"?(.*?)\"?(?=,|$)");

        Matcher matcher = pattern.matcher(line);
        
        while (matcher.find()) {
            String field = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
            fields.add(field);
        }

        return fields;
    }

    public MovieResponse createMovie(Movie movie){

        Movie createdMovie = repository.save(movie);

        MovieResponse response = mapper.entityToDto(createdMovie);

        return response;
    }

    public List<MovieResponse> getAllMovies(){
        List<Movie> getAllMovies = repository.findAll();

        List<MovieResponse> response = new ArrayList<>();

        getAllMovies.forEach(getMovie -> {
            var mapMovie = mapper.entityToDto(getMovie);

            var reviewResponse = reviewService.getReviewsByMovieId(getMovie.getId());

            mapMovie.setReviews(reviewResponse);

            response.add(mapMovie);
        });

        return response;
    }  

    public MovieResponse getMovieById(String id){
        Optional<Movie> getMovie = repository.findById(id);

        var movie = getMovie.get();

        MovieResponse response = mapper.entityToDto(movie);

        return response;
    }
}