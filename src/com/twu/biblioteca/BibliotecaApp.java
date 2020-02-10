package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> bookList = new ArrayList<Book>();
    ArrayList<Movie> movieList = new ArrayList<Movie>();
    ArrayList<User> userList = new ArrayList<User>();
    User currentUser = null;

    public void setUpBooks() {
        bookList.add(new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866));
        bookList.add(new Book("Catcher in the Rye", "J. D. Salinger", 1951));
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
    }
    public void setUpMovies() {
        movieList.add(new Movie("The Dark Knight", 2008, "Christopher Nolan", 9));
        movieList.add(new Movie("The Matrix", 1999, "Lana/Lilly Wachowski", 8));
        movieList.add(new Movie("Aliens", 1986, "James Cameron", 7));
    }
    public void setUpUsers() {
        userList.add(new User("123-4567", "boom", "Alex P", "777 777 7777", "me@website.com"));
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
    public void displayMoviesInStock() {
        String movieString = "";
        for (Movie movie: this.movieList) {
            if (movie.inStock) {
                movieString += movie.toString() + '\n';
            }
        }
        System.out.println(movieString);
    }
    public void displayBooksCheckedOut() {
        String bookString = "";
        for (Book book: this.bookList) {
            if (!book.inStock) {
                bookString += book.toString() + '\n';
            }
        }
        System.out.println(bookString);
    }
    public void displayMoviesCheckedOut() {
        String movieString = "";
        for (Movie movie: this.movieList) {
            if (!movie.inStock) {
                movieString += movie.toString() + '\n';
            }
        }
        System.out.println(movieString);
    }
    public void showMenu() {
        System.out.println("\nSelect an option from the menu below:\n");
        System.out.println("1) List of Books");
        System.out.println("2) Checkout Book");
        System.out.println("3) Return Book");
        System.out.println("4) List of Movies");
        System.out.println("5) Checkout Movie");
        System.out.println("6) Return Movie");
        System.out.println("7) View Current User Info");
        System.out.println("8) Exit");
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
        app.setUpMovies();
        app.setUpUsers();
        while (app.currentUser == null) {
            System.out.println("Login to check-out or return books.");
            System.out.println("Library Number:");
            String libNumber = app.getUserInputAsString();
            for (User user: app.userList) {
                if (user.libraryNumber.equals(libNumber)) {
                    System.out.println("Found User: " + libNumber);
                    System.out.println("Password:");
                    String pw = app.getUserInputAsString();
                    if (user.password.equals(pw)) {
                        app.currentUser = user;
                        System.out.println("Login successful!");
                    } else
                        System.out.println("Incorrect password! Login failed!");
                } else
                    System.out.println("Invalid Library Number! Login failed!");
            }
        }
        app.showMenu();
        while (true) {
            int option = app.getUserInput();
            switch (option) {
                case 1:
                    app.displayBooksInStock();
                    break;
                case 2:
                    app.displayBooksInStock();
                    System.out.println("Enter the title of a book to checkout:");
                    app.checkoutBook(app.getUserInputAsString());
                    break;
                case 3:
                    System.out.println("Books to return:");
                    app.displayBooksCheckedOut();
                    System.out.println("Enter the title of a book to return:");
                    app.returnBook(app.getUserInputAsString());
                    break;
                case 4:
                    app.displayMoviesInStock();
                    break;
                case 5:
                    app.displayMoviesInStock();
                    System.out.println("Enter the name of a movie to checkout:");
                    app.checkoutMovie(app.getUserInputAsString());
                    break;
                case 6:
                    System.out.println("Movies to return:");
                    app.displayMoviesCheckedOut();
                    System.out.println("Enter the name of the movie to return:");
                    app.returnMovie(app.getUserInputAsString());
                    break;
                case 7:
                    System.out.println("Current User Info:");
                    System.out.println(app.currentUser.toString());
                    break;
                case 8:
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

    public Movie checkoutMovie(String title) {
        for (Movie movie: movieList) {
            if (movie.name.equals(title)) {
                movie.checkOut();
                System.out.println("Thank you! Enjoy the movie!");
                return movie;
            }
        }
        System.out.println("Sorry, that movie is not available");
        return null;
    }

    public Book returnBook(String title) {
        for (Book book: bookList) {
            if (book.title.equals(title)) {
                book.returnBook();
                System.out.println("Thank you for returning the book");
                return book;
            }
        }
        System.out.println("That is not a valid book to return.");
        return null;
    }

    public Movie returnMovie(String title) {
        for (Movie movie: movieList) {
            if (movie.name.equals(title)) {
                movie.returnMovie();
                System.out.println("Thank you for returning the movie");
                return movie;
            }
        }
        System.out.println("That is not a valid movie to return.");
        return null;
    }
}
