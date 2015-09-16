package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class LoginOptionTest {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private Book book = new Book(" ", " ", 0);

    @Test
    public void shouldGetInputLibraryNumberAndPasswordFromUser() {
        listOfBooks.add(book);
        Library library = new Library(listOfBooks);
        Console console = mock(Console.class);
        MainMenuOption loginOption = new LoginOption(console, library);
        loginOption.doOperation();
        when(console.getUserInput()).thenReturn("123-4567", "XXX");
        verify(console, times(2)).getUserInput();
    }
}