package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserDetailsOptionTest {
    private User user = new User("123-3456", "SAI", "user");
    private Console console = mock(Console.class);

    @Test
    public void shouldDisplayToStringFormatOfUserDetails() {
        MainMenuOption userDetailsOption = new UserDetailsOption(user, console);

        userDetailsOption.doOperation();

        verify(console).display(user.toString());

    }
}