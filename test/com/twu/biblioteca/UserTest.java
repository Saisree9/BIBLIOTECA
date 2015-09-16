package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void shouldEqualToItself() {
        User user = new User("Sai", "SX");
        assertEquals(user, user);
    }

}