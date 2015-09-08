package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class MainMenuTest {
    @Test
    public void shouldDoListBooksOperationWhenListBooksOptionIsSelected() {
        MainMenuOption listBooksOption = mock(ListBooksOption.class);
        MainMenu mainMenu = new MainMenu(listBooksOption);
        List<Book> listOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Java design patterns", "pankaj", 1887);
        Book book2 = new Book("Head First Java", "Bert", 1991);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        Library library = new Library(listOfBooks);
        Console console = mock(Console.class);
        mainMenu.doOperation(library, console);

        verify(listBooksOption).doOperation(library, console);
    }

    @Test
    public void shouldDoInvalidMenuOperationWhenInvalidOptionIsSelected() {
        MainMenuOption invalidMenuOption = mock(InvalidMenuOption.class);
        MainMenu mainMenu = new MainMenu(invalidMenuOption);
        List<Book> listOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Java design patterns", "pankaj", 1887);
        Book book2 = new Book("Head First Java", "Bert", 1991);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        Library library = new Library(listOfBooks);
        Console console = mock(Console.class);
        mainMenu.doOperation(library, console);

        verify(invalidMenuOption).doOperation(library, console);
    }

    @Test
    public void shouldDoQuitOperationWhenQuitOptionIsSelected() {
        MainMenuOption quit = mock(Quit.class);
        MainMenu mainMenu = new MainMenu(quit);
        List<Book> listOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Java design patterns", "pankaj", 1887);
        Book book2 = new Book("Head First Java", "Bert", 1991);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        Library library = new Library(listOfBooks);
        Console console = mock(Console.class);
        mainMenu.doOperation(library, console);

        verify(quit).doOperation(library, console);
    }

}