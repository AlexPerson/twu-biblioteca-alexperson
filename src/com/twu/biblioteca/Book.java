package com.twu.biblioteca;

public class Book {
    String title;
    String author;
    int pubYear;
    boolean inStock;

    public Book(String title, String author, int pubYear) {
        this.title = title;
        this.author = author;
        this.pubYear = pubYear;
        this.inStock = true;
    }

    public void checkOut() {
        this.inStock = false;
    }

    @Override
    public String toString() {
        return title + " || " + author + " || " + pubYear;
    }
}
