package com.example.elizabethjesseimdb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    DataService dataService;

    public MovieController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return dataService.getMovies();
    }
}