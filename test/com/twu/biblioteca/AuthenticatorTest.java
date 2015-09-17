package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AuthenticatorTest {
    private List<User> registeredUsersList = new ArrayList<User>();

    @Test
    public void shouldReturnUserIfUserRegisteredThatIsUserExistInRegisteredUsersList() {
        registeredUsersList.add(new User("User1", "PassWord", "user"));
        Authenticator authenticator = new Authenticator(registeredUsersList);
        assertEquals(new User("User1", "PassWord", "user"), authenticator.authenticate("User1", "PassWord"));
    }

    @Test
    public void shouldReturnNullIfUserNotRegisteredThatIsUserDoesNotExistInRegisteredUsersList() {
        registeredUsersList.add(new User("User1", "PassWord", "user"));
        Authenticator authenticator = new Authenticator(registeredUsersList);
        assertEquals(null, authenticator.authenticate("User", "Password1"));
    }
}