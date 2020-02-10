package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    String libraryNumber;
    String password;
    ArrayList<Book> booksCheckedOut = new ArrayList<Book>();

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }
}
