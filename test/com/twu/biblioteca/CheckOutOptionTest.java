package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutOptionTest {
    @Test
    public void shouldAskForBookTitle() {
        MainMenuOption checkOutOption = new CheckOutOption();

        List<Book> listOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Java design patterns", "pankaj", 1887);
        Book book2 = new Book("Head First Java", "Bert", 1991);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        Library library = new Library(listOfBooks);
        Console console = mock(Console.class);
        when(console.getUserInput()).thenReturn("Head First Java");
        checkOutOption.doOperation(library, console);
        verify(console).display("Enter booktitle to checkout: ");
    }

    @Test
    public void shouldCheckOutBookSuccessfullyFromLibraryIfBookExists() {
        MainMenuOption checkOutOption = new CheckOutOption();

        List<Book> listOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Java design patterns", "pankaj", 1887);
        Book book2 = new Book("Head First Java", "Bert", 1991);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        Library library = new Library(listOfBooks);
        Console console = mock(Console.class);
        when(console.getUserInput()).thenReturn("Head First Java");
        checkOutOption.doOperation(library, console);
        verify(console).display("Thank you ! Enjoy the book\n");
    }

    @Test
    public void shouldCheckOutUnsuccessfullyFromLibraryIfBookNotExists() {
        MainMenuOption checkOutOption = new CheckOutOption();
        List<Book> listOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Java design patterns", "pankaj", 1887);
        Book book2 = new Book("Head First Java", "Bert", 1991);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        Library library = new Library(listOfBooks);
        Console console = mock(Console.class);
        when(console.getUserInput()).thenReturn("Head");
        checkOutOption.doOperation(library, console);
        verify(console).display("That book is not available\n");

    }
}