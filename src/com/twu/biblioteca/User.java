package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    String libraryNumber;
    String password;
    ArrayList<Book> booksCheckedOut = new ArrayList<Book>();
    String name;
    String phoneNumber;
    String email;

    public User(String libraryNumber, String password, String name, String phoneNumber, String email) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " || " + phoneNumber + " || " + email;
    }
}
