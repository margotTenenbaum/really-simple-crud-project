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
        newMovie.id = index;
        index++;
        movieList.add(newMovie);
        return newMovie;
    }

    public Movie getMovieById(int id) {
        for (Movie m : movieList) {
            if (m.getId() == id)
                return m;
        }
        return null;
    }

    public Movie deleteMovieById(int id) {
        for (Movie m : movieList) {
            if (m.getId() == id) {
                movieList.remove(m);
                return m;
            }
        }
        return null;
    }

    public Movie updateMovie(int id, String s) {
        String[] keyValue = s.split(" ");
        for (Movie m : movieList) {
            if (m.getId() == id) {
                if (keyValue[0].equals("genre")) {
                    m.setGenre(keyValue[1]);
                } else if (keyValue[0].equals("name")) {
                    m.setName(keyValue[1]);
                } else if (keyValue[0].equals("year")) {
                    m.setYear(keyValue[1]);
                } else if (keyValue[0].equals("oscarStatus")) {
                    m.setOscarStatus(keyValue[1]);
                }
                return m;
            }
        }
        return null;
    }
}