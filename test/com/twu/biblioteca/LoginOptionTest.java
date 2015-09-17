package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class LoginOptionTest {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private Book book = new Book(" ", " ", 0);
    private MovieStore movieStore;
    private List<User> users = new ArrayList<>();

    @Test
    public void shouldGetInputLibraryNumberAndPasswordFromUser() {
        users.add(new User("USR1", "PSWRD1", "user"));
        Authenticator authenticator = new Authenticator(users);
        listOfBooks.add(book);
        Library library = new Library(listOfBooks);
        Console console = mock(Console.class);
        MainMenuOption loginOption = new LoginOption(console, library, movieStore, authenticator);
        loginOption.doOperation();
        when(console.getUserInput()).thenReturn("USR1", "PSWRD1");
        verify(console, times(2)).getUserInput();
    }
}