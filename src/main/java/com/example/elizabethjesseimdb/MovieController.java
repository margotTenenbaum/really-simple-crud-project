package com.example.elizabethjesseimdb;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    DataService dataService;

    public MovieController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public List<Movie> getMovies(@RequestParam(defaultValue="", required = false) String genre) {
        return dataService.getMovies(genre);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie newMovie) {
        dataService.addMovie(newMovie);
        return newMovie;
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable int id) {
        return dataService.getMovieById(id);
    }

    @DeleteMapping("/{id}")
    public Movie deleteMovie(@PathVariable int id) {
        return dataService.deleteMovieById(id);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable int id, @RequestBody String updateString) {
        return dataService.updateMovie(id, updateString);
    }
}