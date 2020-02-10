package com.twu.biblioteca;

public class Movie {
    String name;
    int year;
    String director;
    int movieRating;
    boolean inStock;

    public Movie(String name, int year, String director, int movieRating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        this.inStock = true;
    }

    public void checkOut() {
        this.inStock = false;
    }

    @Override
    public String toString() {
        return name + " || " + year + " || " + director + " || " + movieRating;
    }
}
