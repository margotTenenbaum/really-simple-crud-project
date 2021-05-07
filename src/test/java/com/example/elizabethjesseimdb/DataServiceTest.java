package com.example.elizabethjesseimdb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataServiceTest {
    DataService dataService;
    List<Movie> testData;
    Movie movie1;

    @BeforeEach
    void setup() {
        testData = new ArrayList<>();
        dataService = new DataService();
        movie1 = new Movie("The Royal Tenenbaums", "2001", "notNominated", "comedy");
        Movie movie2 = new Movie("Citizen Kane", "1941", "oscarWinner", "drama");
        Movie movie3 = new Movie("The Godfather", "1972", "oscarWinner", "drama");
        testData.add(movie1);
        testData.add(movie2);
        testData.add(movie3);
        dataService.addMovie(movie1);
        dataService.addMovie(movie2);
        dataService.addMovie(movie3);
    }

    @Test
    void getMovies() {
        assertEquals(3, dataService.getMovies().size());
    }

    @Test
    void getMovieByIdReturnsMovieById() {
        Movie actual = dataService.getMovieById(0);
        assertEquals(movie1, actual);
    }

    @Test
    void addedMovieShouldBeInDataService() {
        Movie expected = new Movie("Mortal Kombat", "2021", "notNominated", "action");
        dataService.addMovie(expected);
        Movie actual = dataService.getMovieById(3);
        assertEquals(4, dataService.getMovies().size());
        assertEquals(expected, actual);
    }
}
