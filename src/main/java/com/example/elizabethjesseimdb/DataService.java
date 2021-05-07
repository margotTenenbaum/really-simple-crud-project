package com.example.elizabethjesseimdb;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataService {
    List<Movie> movieList = new ArrayList<>();
    int index = 0;

    public List<Movie> getMovies() {
        return movieList;
    }

    public Movie addMovie(Movie newMovie) {
        movieList.add(newMovie);
        return newMovie;
    }
}