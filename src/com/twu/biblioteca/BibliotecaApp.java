package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

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
                System.out.println("Error: " + option + " is not a valid option!");
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
        BibliotecaApp app = new BibliotecaApp();
        app.setUpBooks();
        app.showMenu();
    }
}
