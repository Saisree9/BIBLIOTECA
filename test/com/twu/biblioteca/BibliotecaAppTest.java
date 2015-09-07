package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.when;

public class BibliotecaAppTest {
    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStart() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Console display = mock(Console.class);

        bibliotecaApp.start(display);

        Mockito.verify(display, times(1)).display("WELCOME TO PUBLIC LIBRARY\n");
    }

    @Test
    public void shouldDisplayListOfTheOptionsToSelect() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Console display = mock(Console.class);

        bibliotecaApp.start(display);

        Mockito.verify(display, times(1)).display("Option1:ListBooks\nEnter the option:");

    }

    @Test
    public void shouldReturnUserInputWhenSelectOptionCalled() {
        String userInput = "1";
        Console input = mock(Console.class);
        when(input.getUserInput()).thenReturn(userInput);
        BibliotecaApp bibliotecaApp = new BibliotecaApp();


        assertEquals(userInput, bibliotecaApp.selectOption(input));
    }

    @Test
    public void shouldDisplayListOfBooksPresentInLibraryWhenOptionOneSelected() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Java design patterns", "pankaj", 1887));
        listOfBooks.add(new Book("Head First Java", "Bert", 1991));
        Library library = new Library(listOfBooks);
        Console display = mock(Console.class);
        when(display.getUserInput()).thenReturn("1");
        bibliotecaApp.start(display);

        Mockito.verify(display, times(1)).display(library.toString());
    }
}

