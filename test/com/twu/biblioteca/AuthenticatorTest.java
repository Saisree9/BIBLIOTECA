package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AuthenticatorTest {
    private List<User> registeredUsersList = new ArrayList<User>();
    private String name="sai";
    private String emailID="sai@gmail.com";
    private String mobileNumber="7660029504";

    @Test
    public void shouldReturnUserIfUserRegisteredThatIsUserExistInRegisteredUsersList() {
        registeredUsersList.add(new User("111-2222", "3", "user", name, emailID, mobileNumber));
        Authenticator authenticator = new Authenticator(registeredUsersList);
        assertEquals(new User("111-2222", "3", "user", name, emailID, mobileNumber), authenticator.authenticate("111-2222", "3"));
    }

    @Test
    public void shouldReturnNullIfUserNotRegisteredThatIsUserDoesNotExistInRegisteredUsersList() {
        registeredUsersList.add(new User("111-2222", "3", "user", name, emailID, mobileNumber));
        Authenticator authenticator = new Authenticator(registeredUsersList);
        assertEquals(null, authenticator.authenticate("111-1122", "3"));
    }
}