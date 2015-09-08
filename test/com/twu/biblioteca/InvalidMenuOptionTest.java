package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvalidMenuOptionTest {
    @Test
    public void shouldDisplaySelectAValidOptionMessage() {
        MainMenuOption invalidMenuOption=new InvalidMenuOption();
        List<Book> listOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Java design patterns", "pankaj", 1887);
        Book book2 = new Book("Head First Java", "Bert", 1991);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        Library library = new Library(listOfBooks);
        Console console = mock(Console.class);
        invalidMenuOption.doOperation(library, console);
        verify(console).display("Select a valid option\n");

    }
}