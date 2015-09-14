package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnOptionTest {

    private List<Book> listOfBooks = new ArrayList<Book>();
    private Console console = mock(Console.class);
    private Book book1 = new Book("Java design patterns", "pankaj", 1887);
    private Book book2 = new Book("Head First Java", "Bert", 1991);
    private MainMenuOption returnOption;
    private MainMenuOption checkOutOption;

    @Before
    public void setUp() {
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        Library library = new Library(listOfBooks);
        returnOption = new ReturnOption(library, console);
        checkOutOption = new CheckOutOption(library, console);
    }

    @Test
    public void shouldAskForReturnBookTitle() {
        when(console.getUserInput()).thenReturn("Head First Java");

        returnOption.doOperation();

        verify(console).display("Enter return book title: ");
    }

    @Test
    public void shouldReturnBookSuccessfullyToLibraryWhenItCheckedOut() {
        when(console.getUserInput()).thenReturn("Head First Java");

        checkOutOption.doOperation();
        returnOption.doOperation();

        verify(console).display("Thank You ! for returning book\n");
    }

    @Test
    public void shouldReturnBookUnSuccessfullyTOLibraryWhenItIsNotCheckedOut() {
        when(console.getUserInput()).thenReturn("Head First Java");

        returnOption.doOperation();

        verify(console).display("That is not a valid book to return\n");

    }
}