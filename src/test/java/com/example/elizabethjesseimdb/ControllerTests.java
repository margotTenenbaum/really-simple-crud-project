package com.example.elizabethjesseimdb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ControllerTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    DataService dataService;

    Movie movie1;

    ArrayList<Movie> movieList;

    @BeforeEach
    void setup() {
        movieList = new ArrayList<>();
        movie1 = new Movie("The Royal Tenenbaums", "2001", "notNominated", "comedy");
        movieList.add(movie1);
    }

    @Test
    void getMovies() throws Exception {
        when(dataService.getMovies("")).thenReturn(movieList);

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void addMovie() throws Exception {
        Movie postMovie = new Movie("Citizen Kane", "1941", "oscarWinner", "drama");
        when(dataService.addMovie(any(Movie.class))).thenReturn(postMovie);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Citizen Kane\",\"year\":\"1941\",\"oscarStatus\":\"oscarWinner\",\"genre\":\"drama\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Citizen Kane"));

    }

    @Test
    void getMovieById() throws Exception{
        when(dataService.getMovieById(1)).thenReturn(movie1);

        mockMvc.perform(get("/movies/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("The Royal Tenenbaums"));
    }

    @Test
    void deleteMovieById() throws Exception{
        when(dataService.deleteMovieById(1)).thenReturn(movie1);

        mockMvc.perform(delete("/movies/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("The Royal Tenenbaums"));
    }

    @Test
    void updateMovie() throws Exception {
        movie1.setGenre("drama");
        when(dataService.updateMovie(1, "genre drama")).thenReturn(movie1);

        mockMvc.perform(put("/movies/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("genre drama"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("genre").value("drama"));

    }

    @Test
    void getRequestWithQueryParamsGetsCorrectMovie() throws Exception {
        when(dataService.getMovies("comedy")).thenReturn(movieList);

        mockMvc.perform(get("/movies?genre=comedy"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}