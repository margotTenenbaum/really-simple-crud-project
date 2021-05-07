package com.example.elizabethjesseimdb;

public class Movie {
    String name;
    String year;
    String oscarStatus;
    String genre;

    Movie() {

    }

    Movie(String name, String year, String oscarStatus, String genre) {
        this.name = name;
        this.year = year;
        this.oscarStatus = oscarStatus;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getOscarStatus() {
        return oscarStatus;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "{\"name\":" + name + ", \"year\":" + year + ", \"oscarStatus\":" + oscarStatus + ", \"genre\":" + genre + "}";
    }
}