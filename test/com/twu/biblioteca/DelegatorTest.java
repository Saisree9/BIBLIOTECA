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
    private MainMenuOption mainMenuOption;
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

        delegator.getMainMenuOption(console, library);

        verify(console).getUserInput();
    }

    @Test
    public void shouldReturnMainMenuListBooksOptionWhenOptionOneIsSelected() {
        when(console.getUserInput()).thenReturn("1");

        mainMenuOption = delegator.getMainMenuOption(console, library);

        assertEquals(mainMenuOption.getClass(),ListBooksOption.class);
    }

    @Test
    public void shouldReturnMainMenuQuitWhenOptionTwoIsSelected() {
        when(console.getUserInput()).thenReturn("2");

        mainMenuOption = delegator.getMainMenuOption(console, library);

        assertEquals(mainMenuOption.getClass(),Quit.class);

    }

    @Test
    public void shouldReturnMainMenuCheckOutOptionWhenOptionThreeIsSelected() {
        when(console.getUserInput()).thenReturn("3");

        mainMenuOption = delegator.getMainMenuOption(console, library);

        assertEquals(mainMenuOption.getClass(),CheckOutOption.class);

    }

    @Test
    public void shouldReturnMainMenuReturnOptionWhenOptionFourIsSelected() {
        when(console.getUserInput()).thenReturn("4");

        mainMenuOption = delegator.getMainMenuOption(console, library);

        assertEquals(mainMenuOption.getClass(),ReturnOption.class);

    }

    @Test
    public void shouldReturnMainMenuInvalidMenuOptionWhenInvalidOptionIsSelected() {
        when(console.getUserInput()).thenReturn("5");

        mainMenuOption = delegator.getMainMenuOption(console, library);

        assertEquals(mainMenuOption.getClass(),InvalidMenuOption.class);

    }

}