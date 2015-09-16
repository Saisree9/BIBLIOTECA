package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AuthenticatorTest {
    private List<User> users = new ArrayList<User>();

    @Test
    public void shouldReturnTrueIfUserRegisteredThatIsUserExistInRegisteredUsersList() {
        users.add(new User("User1", "PassWord"));
        Authenticator authenticator = new Authenticator(users);
        assertTrue(authenticator.authenticate(new User("User1", "PassWord")));
    }

    @Test
    public void shouldReturnFalseIfUserRegisteredThatIsUserDoesNotExistInRegisteredUsersList() {
        users.add(new User("User1", "PassWord"));
        Authenticator authenticator = new Authenticator(users);
        assertFalse(authenticator.authenticate(new User("User", "PassWord1")));
    }
}