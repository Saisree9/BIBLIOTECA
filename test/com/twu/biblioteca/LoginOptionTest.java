package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LoginOptionTest {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private Book book = new Book(" ", " ", 0);
    private MovieStore movieStore;
    private List<User> users = new ArrayList<>();
    private Console console = mock(Console.class);
    private Library library;
    private LoginOption loginOption;
    private Authenticator authenticator;

    @Before
    public void setUp() {
        users.add(new User("USR1", "PSWRD1", "user"));
        listOfBooks.add(book);
        library = new Library(listOfBooks);
        authenticator = new Authenticator(users);
        loginOption = new LoginOption(console, library, movieStore, authenticator);

    }

    @Test
    public void shouldGetInputLibraryNumberAndPasswordFromUser() {
        when(console.getUserInput()).thenReturn("USR1", "PSWRD1");
        loginOption.doOperation();
        verify(console, times(2)).getUserInput();
    }

    @Test
    public void shouldReturnRegisteredUserDetailsAfterAuthenticationOfLibraryNumberAndPassword() {
        when(console.getUserInput()).thenReturn("USR1", "PSWRD1");
        User actual = loginOption.authenticateUserDetails();
        assertEquals(new User("USR1", "PSWRD1", "user"), actual);
    }

    @Test
    public void shouldDisplayUserMainMenuOptionsWhenTheRoleOfTheCustomerIsUser() {
        when(console.getUserInput()).thenReturn("USR1", "PSWRD1");
        loginOption.doOperation();
        verify(console).display("Option1:ListBooks\n" +
                "Option2:UserDetails\n" +
                "Option3:CheckOutBooks\n" +
                "Option4:ReturnOption\n" +
                "Option5:ListMovies\n" +
                "Option6:CheckOutMovie\n" +
                "Option7:logout\n" +
                "\n" +
                "EnterTheOption:");

    }
}