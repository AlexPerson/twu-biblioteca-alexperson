package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ExampleTest {

    @Test
    public void individualBooksMayBeCheckedOut() {
        BibliotecaApp app = new BibliotecaApp();
        app.setUpBooks();
        Book selectedBook = app.bookList.get(0);
        selectedBook.checkOut();
        app.displayBooksInStock();
        assertFalse(selectedBook.inStock);
    }

    @Test
    public void userCanSelectABookToCheckoutBasedOnTitle() {
        BibliotecaApp app = new BibliotecaApp();
        app.setUpBooks();
        Book selectedBook = app.checkoutBook("Crime and Punishment");
        app.displayBooksInStock();
        assertFalse(selectedBook.inStock);
    }
}
