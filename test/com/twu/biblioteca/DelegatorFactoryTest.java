package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DelegatorFactoryTest {
    private List<User> users = new ArrayList<>();
    private Console console = mock(Console.class);
    private Authenticator authenticator;
    private MainMenuOptionDelegator mainMenuOptionDelegator;
    private DelegatorFactory delegatorFactory = new DelegatorFactory(console, authenticator);
    private String name = "sai";
    private String emailID = "sai@gmail.com";
    private String mobileNumber = "7660029504";

    @Before
    public void setUp() {
        users.add(new User("111-2222", "3", "user", "sai", "sai@gmail.com", "7660029504"));
        users.add(new User("111-2223", "4", "librarian", "sree", "sree@gmail.com", "7660029503"));
        authenticator = new Authenticator(users);

    }

    @Test
    public void shouldDisplayUserMainMenuOptionsWhenTheRoleOfTheCustomerIsUser() {
        delegatorFactory.getMainMenuOptionDelegator(new User("111-2222", "3", "user", name, emailID, mobileNumber));
        verify(console).display("1:ListBooks\n" +
                "2:UserDetails\n" +
                "3:CheckOutBooks\n" +
                "4:ReturnOption\n" +
                "5:ListMovies\n" +
                "6:CheckOutMovie\n" +
                "7:logout\n" +
                "\n" +
                "EnterTheOption:\n");

    }

    @Test
    public void shouldReturnUserMainMenuOptionDelegatorIfTheRoleIsUser() {
        User user = new User("111-2222", "3", "user", name, emailID, mobileNumber);
        mainMenuOptionDelegator = delegatorFactory.getMainMenuOptionDelegator(user);
        assertEquals(mainMenuOptionDelegator.getClass(), NormalUserMainMenuOptionsDelegator.class);
    }

    @Test
    public void shouldDisplayLibrarianMainMenuOptionsWhenTheRoleOfTheCustomerIsLibrarian() {
        delegatorFactory.getMainMenuOptionDelegator(new User("111-2222", "3", "librarian", name, emailID, mobileNumber));
        verify(console).display("1:ListBooks\n" +
                "2:UserDetails\n" +
                "3:CheckOutBooks\n" +
                "4:ReturnOption\n" +
                "5:ListMovies\n" +
                "6:CheckOutMovie\n" +
                "7:logout\n" +
                "8:BookDetails\n" +
                "\n" +
                "EnterTheOption:\n");

    }

    @Test
    public void shouldReturnLibrarianMainMenuOptionDelegatorIfTheRoleIsLibrarian() {
        User user = new User("111-2222", "3", "user", name, emailID, mobileNumber);
        mainMenuOptionDelegator = delegatorFactory.getMainMenuOptionDelegator(user);
        assertEquals(mainMenuOptionDelegator.getClass(), NormalUserMainMenuOptionsDelegator.class);
    }

}