package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> bookList = new ArrayList<Book>();

    public void setUpBooks() {
        bookList.add(new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866));
        bookList.add(new Book("Catcher in the Rye", "J. D. Salinger", 1951));
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
    }
    public void displayBooksInStock() {
        String bookString = "";
        for (Book book: this.bookList) {
            if (book.inStock) {
                bookString += book.toString() + '\n';
            }

        }
        System.out.println(bookString);
    }
    public void showMenu() {
        System.out.println("\nSelect an option from the menu below:\n");
        System.out.println("1) List of Books");
        System.out.println("2) Checkout Book");
        System.out.println("3) Exit");
    }
    public int getUserInput() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\n" +
                "Selected option: ");

        int option = Integer.parseInt(myObj.nextLine());  // Read user input

        return option;
    }
    public String getUserInputAsString() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String inputString = myObj.nextLine();
        return inputString;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
        BibliotecaApp app = new BibliotecaApp();
        app.setUpBooks();
        app.showMenu();
        while (true) {
            int option = app.getUserInput();
            switch (option) {
                case 1:
                    app.displayBooksInStock();
                    break;
                case 2:
                    app.displayBooksInStock();
                    System.out.println("Enter a books title to check it out:");
                    String test = app.getUserInputAsString();
                    app.checkoutBook(test);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Please select a valid option!");
            }
            app.showMenu();
        }
    }

    public Book checkoutBook(String title) {
        for (Book book: bookList) {
            if (book.title.equals(title)) {
                book.checkOut();
                System.out.println("Thank you! Enjoy the book!");
                return book;
            }
        }
        System.out.println("Sorry, that book is not available");
        return null;
    }
}
