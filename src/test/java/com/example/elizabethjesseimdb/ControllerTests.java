package com.example.elizabethjesseimdb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ControllerTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    DataService dataService;

    ArrayList<Movie> movieList;

    @BeforeEach
    void setup() {
        movieList = new ArrayList<Movie>();
        Movie movie1 = new Movie("The Royal Tenenbaums", "2001", "notNominated", "comedy");
        movieList.add(movie1);
    }

    @Test
    void getMovies() throws Exception {
        when(dataService.getMovies()).thenReturn(movieList);

        mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
                .andExpect(status().isOk());
    }
}