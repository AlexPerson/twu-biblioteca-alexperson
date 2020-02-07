package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> bookList = new ArrayList<Book>();
    private void setUpBooks() {
        bookList.add(new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866));
        bookList.add(new Book("Catcher in the Rye", "J. D. Salinger", 1951));
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
    }
    public void displayBooks() {
        for (Book book: this.bookList) {
            book.toString();
        }
    }
    public void showMenu() {
        System.out.println("\nSelect an option from the menu below:\n");
        System.out.println("1) List of Books");
        getUserInput();
    }
    public void getUserInput() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\n" +
                "Selected option: ");

        int option = Integer.parseInt(myObj.nextLine());  // Read user input

        switch (option) {
            case 1:
                displayBooks();
                break;
            default:
                System.out.println("Please select a valid option!");
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
        BibliotecaApp app = new BibliotecaApp();
        app.setUpBooks();
        app.showMenu();
    }
}
