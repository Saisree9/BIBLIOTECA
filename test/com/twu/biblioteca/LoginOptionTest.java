package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

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
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
    private String name="sai";
    private String emailID="sai@gmail.com";
    private String mobileNumber="7660029504";


    @Before
    public void setUp() {
        users.add(new User("111-2222", "3", "user", "sai", "sai@gmail.com", "7660020504"));
        users.add(new User("111-2221", "4", "librarian", "sree", "sree@gmail.com", "7660029504"));
        listOfBooks.add(book);
        library = new Library(listOfBooks);
        authenticator = new Authenticator(users);
        loginOption = new LoginOption(console, library, movieStore, authenticator, delegatorFactory);

    }

    @Test
    public void shouldGetInputLibraryNumberAndPasswordFromUser() {
        when(console.getUserInput()).thenReturn("111-2222", "3", "1", "7", "2");

        exit.expectSystemExitWithStatus(0);

        loginOption.doOperation();

        verify(console, times(5)).getUserInput();
    }

    @Test
    public void shouldDisplayUserMainMenuOptionsWhenTheRoleOfTheCustomerIsUser() {
        when(console.getUserInput()).thenReturn("111-2222", "3", "1", "7", "2");

        exit.expectSystemExitWithStatus(0);

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
        User user = new User("111-2222", "3", "user", name, emailID, mobileNumber);
        mainMenuOptionDelegator = delegatorFactory.getMainMenuOptionDelegator(user);

        when(console.getUserInput()).thenReturn("111-2222", "3", "1", "7", "2");
        exit.expectSystemExitWithStatus(0);
        loginOption.doOperation();

        assertEquals(mainMenuOptionDelegator.getClass(), NormalUserMainMenuOptionsDelegator.class);
    }

    @Test
    public void shouldDisplayLibrarianMainMenuOptionsWhenTheRoleOfTheCustomerIsLibrarian() {
        when(console.getUserInput()).thenReturn("111-2221", "4", "1", "8", "2");

        exit.expectSystemExitWithStatus(0);
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
        User user = new User("111-2222", "3", "user", name, emailID, mobileNumber);
        mainMenuOptionDelegator = delegatorFactory.getMainMenuOptionDelegator(user);

        when(console.getUserInput()).thenReturn("111-2221", "4", "1", "8", "2");

        exit.expectSystemExitWithStatus(0);
        loginOption.doOperation();

        assertEquals(mainMenuOptionDelegator.getClass(), NormalUserMainMenuOptionsDelegator.class);
    }

    @Test
    public void shouldGetMainMenuOptionAndDoOperationAfterDelegation() {
        String libraryNumber = "111-2222";
        String passWord = "3";
        User user = new User("111-2222", "3", "Librarian", name, emailID, mobileNumber);
        DelegatorFactory delegatorFactory = mock(DelegatorFactory.class);
        MainMenuOptionDelegator mainMenuOptionDelegator = mock(LibrarianMainMenuOptionsDelegator.class);
        MainMenuOption mainMenuOption = mock(LogOutOption.class);
        Authenticator authenticator = mock(Authenticator.class);
        LoginOption loginOption = new LoginOption(console, library, movieStore, authenticator, delegatorFactory);

        when(delegatorFactory.getMainMenuOptionDelegator(user)).thenReturn(mainMenuOptionDelegator);
        when(console.getUserInput()).thenReturn(libraryNumber).thenReturn(passWord);
        when(mainMenuOptionDelegator.getMainMenuOption(console, library, movieStore)).thenReturn(mainMenuOption).thenReturn(new Quit());
        when(authenticator.authenticate(libraryNumber, passWord)).thenReturn(user);
        exit.expectSystemExitWithStatus(0);


        loginOption.doOperation();

        verify(authenticator).authenticate(libraryNumber, passWord);
        verify(delegatorFactory).getMainMenuOptionDelegator(user);
        verify(mainMenuOptionDelegator).getMainMenuOption(console, library, movieStore);
        verify(mainMenuOption).doOperation();
    }

    @Test
    public void shouldDoOperationOnlyWhenTheUserNotEqualToNull() {
        String libraryNumber = "111-2222";
        String passWord = "3";
        User user = new User("111-2222", "3", "Librarian", name, emailID, mobileNumber);
        DelegatorFactory delegatorFactory = mock(DelegatorFactory.class);
        MainMenuOptionDelegator mainMenuOptionDelegator = mock(LibrarianMainMenuOptionsDelegator.class);
        MainMenuOption mainMenuOption = mock(MainMenuOption.class);
        Authenticator authenticator = mock(Authenticator.class);
        LoginOption loginOption = new LoginOption(console, library, movieStore, authenticator, delegatorFactory);

        when(delegatorFactory.getMainMenuOptionDelegator(user)).thenReturn(mainMenuOptionDelegator);
        when(console.getUserInput()).thenReturn(libraryNumber).thenReturn(passWord);
        when(mainMenuOptionDelegator.getMainMenuOption(console, library, movieStore)).thenReturn(mainMenuOption).thenReturn(new Quit());
        when(authenticator.authenticate(libraryNumber, passWord)).thenReturn(user);
        exit.expectSystemExitWithStatus(0);


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