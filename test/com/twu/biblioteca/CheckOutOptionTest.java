package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutOptionTest {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private Console console = mock(Console.class);
    private Book book1 = new Book("Java design patterns", "pankaj", 1887);
    private Book book2 = new Book("Head First Java", "Bert", 1991);
    private MainMenuOption checkOutOption;
    private User user = new User("222-3333", "4", "user", "sai", "sai@gmail.com", "7660029504");


    @Before
    public void setUp() {
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        Library library = new Library(listOfBooks);
        checkOutOption = new CheckOutBookOption(library, console, user);
    }

    @Test
    public void shouldAskForBookTitle() {
        when(console.getUserInput()).thenReturn("Head First Java");

        checkOutOption.doOperation();

        verify(console).display("Enter booktitle to checkout: ");
    }

    @Test
    public void shouldCheckOutBookSuccessfullyFromLibraryIfBookExists() {
        when(console.getUserInput()).thenReturn("Head First Java");

        checkOutOption.doOperation();

        verify(console).display("Thank you ! Enjoy the book\n");
    }

    @Test
    public void shouldCheckOutUnsuccessfullyFromLibraryIfBookNotExists() {
        when(console.getUserInput()).thenReturn("Head");

        checkOutOption.doOperation();

        verify(console).display("That book is not available\n");

    }
}