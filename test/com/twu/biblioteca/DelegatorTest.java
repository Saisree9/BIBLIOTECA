package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DelegatorTest {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private Console console = mock(Console.class);
    private Book book1 = new Book("Java design patterns", "pankaj", 1887);
    private Book book2 = new Book("Head First Java", "Bert", 1991);
    Library library;
    private MainMenu mainMenu;
    Delegator delegator;

    @Before
    public void setUp() {
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        library = new Library(listOfBooks);
        delegator = new Delegator();
    }

    @Test
    public void shouldGetOptionInputFromUser() {
        when(console.getUserInput()).thenReturn("1");

        delegator.getMainMenuWithOption(console, library);

        verify(console).getUserInput();
    }

    @Test
    public void shouldReturnMainMenuWithListBooksOptionWhenOptionOneIsSelected() {
        when(console.getUserInput()).thenReturn("1");

        mainMenu = delegator.getMainMenuWithOption(console, library);

        assertEquals(new MainMenu(new ListBooksOption(library, console)), mainMenu);
    }

    @Test
    public void shouldReturnMainMenuWithQuitWhenOptionTwoIsSelected() {
        when(console.getUserInput()).thenReturn("2");

        mainMenu = delegator.getMainMenuWithOption(console, library);

        assertEquals(new MainMenu(new Quit()), mainMenu);

    }

    @Test
    public void shouldReturnMainMenuWithCheckOutOptionWhenOptionThreeIsSelected() {
        when(console.getUserInput()).thenReturn("3");

        mainMenu = delegator.getMainMenuWithOption(console, library);

        assertEquals(new MainMenu(new CheckOutOption(library, console)), mainMenu);

    }

    @Test
    public void shouldReturnMainMenuWithReturnOptionWhenOptionFourIsSelected() {
        when(console.getUserInput()).thenReturn("4");

        mainMenu = delegator.getMainMenuWithOption(console, library);

        assertEquals(new MainMenu(new ReturnOption(library, console)), mainMenu);

    }

    @Test
    public void shouldReturnMainMenuWithInvalidMenuOptionWhenInvalidOptionIsSelected() {
        when(console.getUserInput()).thenReturn("5");

        mainMenu = delegator.getMainMenuWithOption(console, library);

        assertEquals(new MainMenu(new InvalidMenuOption(console)), mainMenu);

    }

}