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

    @Before
    public void setUp() {
        users.add(new User("USR1", "PSWRD1", "user"));
        users.add(new User("USR2", "PSWRD2", "librarian"));
        authenticator = new Authenticator(users);

    }

    @Test
    public void shouldDisplayUserMainMenuOptionsWhenTheRoleOfTheCustomerIsUser() {
        delegatorFactory.getMainMenuOptionDelegator(new User("USR1", "PSWRD1", "user"));
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
        assertEquals(mainMenuOptionDelegator.getClass(), NormalUserMainMenuOptionsDelegator.class);
    }

    @Test
    public void shouldDisplayLibrarianMainMenuOptionsWhenTheRoleOfTheCustomerIsLibrarian() {
        delegatorFactory.getMainMenuOptionDelegator(new User("USR1", "PSWRD1", "librarian"));
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
        User user = new User("USR1", "PSWRD1", "user");
        mainMenuOptionDelegator = delegatorFactory.getMainMenuOptionDelegator(user);
        assertEquals(mainMenuOptionDelegator.getClass(), NormalUserMainMenuOptionsDelegator.class);
    }

}