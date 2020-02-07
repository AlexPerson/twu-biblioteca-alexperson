package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    ArrayList<Book> bookList = new ArrayList<Book>();
    private void setUpBooks() {
        bookList.add(new Book("Crime and Punishment"));
        bookList.add(new Book("Catcher in the Rye"));
        bookList.add(new Book("To Kill a Mockingbird"));
    }
    public void displayBooks() {
        for (Book book: this.bookList) {
            System.out.println(book.title);
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
        BibliotecaApp app = new BibliotecaApp();
        app.setUpBooks();
        app.displayBooks();
    }
}
