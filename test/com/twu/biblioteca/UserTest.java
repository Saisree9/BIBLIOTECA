package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {
    @Test
    public void shouldEqualToItself() {
        User user = new User("Sai", "SX");
        assertEquals(user, user);
    }

    @Test
    public void shouldNotEqualsToNull() {
        User user = new User("Sai", "SX");
        assertNotEquals(null, user);
    }

}