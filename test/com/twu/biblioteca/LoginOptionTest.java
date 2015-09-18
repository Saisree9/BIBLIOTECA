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
    private MainMenuOptionDelegator mainMenuOptionDelegator;
    private DelegatorFactory delegatorFactory = new DelegatorFactory(console, authenticator);

    @Before
    public void setUp() {
        users.add(new User("USR1", "PSWRD1", "user"));
        users.add(new User("USR2", "PSWRD2", "librarian"));
        listOfBooks.add(book);
        library = new Library(listOfBooks);
        authenticator = new Authenticator(users);
        loginOption = new LoginOption(console, library, movieStore, authenticator, delegatorFactory);

    }

    @Test
    public void shouldGetInputLibraryNumberAndPasswordFromUser() {
        when(console.getUserInput()).thenReturn("USR1", "PSWRD1", "1");

        loginOption.doOperation();

        verify(console, times(3)).getUserInput();
    }

    @Test
    public void shouldDisplayUserMainMenuOptionsWhenTheRoleOfTheCustomerIsUser() {
        when(console.getUserInput()).thenReturn("USR1", "PSWRD1", "1");

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

    @Test
    public void shouldReturnUserMainMenuOptionDelegatorIfTheRoleIsUser() {
        User user = new User("USR1", "PSWRD1", "user");
        mainMenuOptionDelegator = delegatorFactory.getMainMenuOptionDelegator(user);

        when(console.getUserInput()).thenReturn("USR1", "PSWRD1", "1");

        loginOption.doOperation();

        assertEquals(mainMenuOptionDelegator.getClass(), UserMainMenuOptionsDelegator.class);
    }

    @Test
    public void shouldDisplayLibrarianMainMenuOptionsWhenTheRoleOfTheCustomerIsLibrarian() {
        when(console.getUserInput()).thenReturn("USR2", "PSWRD2", "1");
        loginOption.doOperation();
        verify(console).display("Option1:ListBooks\n" +
                "Option2:UserDetails\n" +
                "Option3:CheckOutBooks\n" +
                "Option4:ReturnOption\n" +
                "Option5:ListMovies\n" +
                "Option6:CheckOutMovie\n" +
                "Option7:logout\n" +
                "Option8:BookDetails\n" +
                "\n" +
                "EnterTheOption:");

    }

    @Test
    public void shouldReturnLibrarianMainMenuOptionDelegatorIfTheRoleIsLibrarian() {
        when(console.getUserInput()).thenReturn("USR2", "PSWRD2", "1");
        loginOption.doOperation();
        User user = new User("USR1", "PSWRD1", "user");
        mainMenuOptionDelegator = delegatorFactory.getMainMenuOptionDelegator(user);
        assertEquals(mainMenuOptionDelegator.getClass(), UserMainMenuOptionsDelegator.class);
    }

    @Test
    public void shouldGetMainMenuOptionAndDoOperationAfterDelegation() {
        String libraryNumber = "USR1";
        String passWord = "PSWRD1";
        User user = new User("USR1", "PSWRD1", "Librarian");
        DelegatorFactory delegatorFactory = mock(DelegatorFactory.class);
        MainMenuOptionDelegator mainMenuOptionDelegator = mock(LibrarianMainMenuOptionsDelegator.class);
        MainMenuOption mainMenuOption = mock(MainMenuOption.class);
        Authenticator authenticator = mock(Authenticator.class);
        LoginOption loginOption = new LoginOption(console, library, movieStore, authenticator, delegatorFactory);

        when(delegatorFactory.getMainMenuOptionDelegator(user)).thenReturn(mainMenuOptionDelegator);
        when(console.getUserInput()).thenReturn(libraryNumber).thenReturn(passWord);
        when(mainMenuOptionDelegator.getMainMenuOption(console, library, movieStore)).thenReturn(mainMenuOption);
        when(authenticator.authenticate(libraryNumber, passWord)).thenReturn(user);

        loginOption.doOperation();

        verify(authenticator).authenticate(libraryNumber, passWord);
        verify(delegatorFactory).getMainMenuOptionDelegator(user);
        verify(mainMenuOptionDelegator).getMainMenuOption(console, library, movieStore);
        verify(mainMenuOption).doOperation();
    }

    @Test
    public void shouldDoOperationOnlyWhenTheUserNotEqualToNull() {
        String libraryNumber = "USR1";
        String passWord = "PSWRD1";
        User user = new User("USR1", "PSWRD1", "Librarian");
        DelegatorFactory delegatorFactory = mock(DelegatorFactory.class);
        MainMenuOptionDelegator mainMenuOptionDelegator = mock(LibrarianMainMenuOptionsDelegator.class);
        MainMenuOption mainMenuOption = mock(MainMenuOption.class);
        Authenticator authenticator = mock(Authenticator.class);
        LoginOption loginOption = new LoginOption(console, library, movieStore, authenticator, delegatorFactory);

        when(delegatorFactory.getMainMenuOptionDelegator(user)).thenReturn(mainMenuOptionDelegator);
        when(console.getUserInput()).thenReturn(libraryNumber).thenReturn(passWord);
        when(mainMenuOptionDelegator.getMainMenuOption(console, library, movieStore)).thenReturn(mainMenuOption);
        when(authenticator.authenticate(libraryNumber, passWord)).thenReturn(user);

        loginOption.doOperation();

        verify(authenticator).authenticate(libraryNumber, passWord);
        verify(delegatorFactory).getMainMenuOptionDelegator(user);
        verify(mainMenuOptionDelegator).getMainMenuOption(console, library, movieStore);
        verify(mainMenuOption).doOperation();
    }

    @Test
    public void shouldDisplayMessageWhenUserEqualToNull() {
        DelegatorFactory delegatorFactory = mock(DelegatorFactory.class);
        Authenticator authenticator = mock(Authenticator.class);
        LoginOption loginOption = new LoginOption(console, library, movieStore, authenticator, delegatorFactory);

        loginOption.doOperation();
        
        verify(console).display("Authentication failed");
    }


}