package com.twu.biblioteca;

public class Book {
    String title;
    String author;
    int pubYear;
    public Book(String title, String author, int pubYear) {
        this.title = title;
        this.author = author;
        this.pubYear = pubYear;
    }

    @Override
    public String toString() {
        String bookString = title + " || " + author + " || " + pubYear;
        System.out.println(bookString);
        return bookString;
    }
}
