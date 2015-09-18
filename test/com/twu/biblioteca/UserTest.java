package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void shouldEqualToItself() {
        User user = new User("Sai", "SX", "user");
        assertEquals(user, user);
    }

    @Test
    public void shouldNotEqualsToNull() {
        User user = new User("Sai", "SX", "user");
        assertNotEquals(null, user);
    }

    @Test
    public void shouldEqualToUserHavingSameLibraryNumberAndPassword() {
        User user1 = new User("Sai-sree", "e", "user");
        User user2 = new User("Sai-sree", "e", "user");
        assertEquals(user1, user2);
    }

    @Test
    public void shouldEqualToUserHavingSameLibraryNumberAndPasswordAndHasValidLibraryNumber() {
        User user1 = new User("Sai-sree", "e", "user");
        User user2 = new User("Sai-sree", "e", "user1");
        assertEquals(user1, user2);
    }

    @Test
    public void shouldEqualToAnotherUserIfHashCodeIsSame() {
        User user1 = new User(" Sai", "S", "user");
        User user2 = new User(" Sai", "S", "user");
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void shouldDisplayToStringFormatOfGivenUser() {
        User user1 = new User(" Sai", "S", "user");
        assertEquals("LibraryNumber=' Sai', PassWord='S', Role='user'", user1.toString());
    }

    @Test
    public void shouldReturnTrueIfLibraryNumberIsValid() {
        User user1 = new User("Sai-sree", "S", "user");
        assertTrue(user1.hasValidLibraryNumber());
    }

    @Test
    public void shouldReturnFalseIfLibraryNumberIsInValid() {
        User user1 = new User("Saisree", "S", "user");
        assertFalse(user1.hasValidLibraryNumber());
    }

    @Test
    public void shouldReturnRoleOfUser() {
        User user1 = new User("Saisree", "S", "user");
        assertEquals("user", user1.getRole());
    }


}