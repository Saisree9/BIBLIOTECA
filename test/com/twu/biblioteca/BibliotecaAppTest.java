package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class BibliotecaAppTest {
    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStart() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Display display = mock(Display.class);

        bibliotecaApp.start(display);

        Mockito.verify(display, times(1)).display("WELCOME TO PUBLIC LIBRARY\n");
    }

    @Test
    public void shouldDisplayListOfBooksPresentInLibrary() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Java design patterns", "pankaj", 1887));
        listOfBooks.add(new Book("Head First Java", "Bert", 1991));
        Library library = new Library(listOfBooks);
        Display display = mock(Display.class);

        bibliotecaApp.start(display);

        Mockito.verify(display, times(1)).display(library.toString());

    }
}