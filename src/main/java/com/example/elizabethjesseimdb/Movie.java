package com.example.elizabethjesseimdb;

public class Movie {
    int id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setOscarStatus(String oscarStatus) {
        this.oscarStatus = oscarStatus;
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

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "{\"name\":" + name + ", \"year\":" + year + ", \"oscarStatus\":" + oscarStatus + ", \"genre\":" + genre + "}";
    }
}