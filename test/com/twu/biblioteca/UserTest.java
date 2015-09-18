package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private String name = "sai";
    private String emailID = "sai@email.com";
    private String mobileNumber = "7660029504";

    @Test
    public void shouldEqualToItself() {
        User user = new User("Sai", "SX", "user", name, emailID, mobileNumber);
        assertEquals(user, user);
    }

    @Test
    public void shouldNotEqualsToNull() {
        User user = new User("Sai", "SX", "user", name, emailID, mobileNumber);
        assertNotEquals(null, user);
    }

    @Test
    public void shouldEqualToUserHavingSameLibraryNumberAndPassword() {
        User user1 = new User("Sai-sree", "e", "user", name, emailID, mobileNumber);
        User user2 = new User("Sai-sree", "e", "user", name, emailID, mobileNumber);
        assertEquals(user1, user2);
    }

    @Test
    public void shouldEqualToUserHavingSameLibraryNumberAndPasswordAndHasValidLibraryNumber() {
        User user1 = new User("Sai-sree", "e", "user", name, emailID, mobileNumber);
        User user2 = new User("Sai-sree", "e", "user1", name, emailID, mobileNumber);
        assertEquals(user1, user2);
    }

    @Test
    public void shouldEqualToAnotherUserIfHashCodeIsSame() {
        User user1 = new User(" Sai", "S", "user", name, emailID, mobileNumber);
        User user2 = new User(" Sai", "S", "user", name, emailID, mobileNumber);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void shouldDisplayToStringFormatOfGivenUser() {
        User user1 = new User(" Sai", "S", "user", name, emailID, mobileNumber);
        assertEquals("libraryNumber=' Sai', role='user', name='sai', emailID='sai@email.com', mobileNumber='7660029504'\n", user1.toString());
    }

    @Test
    public void shouldReturnTrueIfLibraryNumberIsValid() {
        User user1 = new User("Sai-sree", "S", "user", name, emailID, mobileNumber);
        assertTrue(user1.hasValidLibraryNumber());
    }

    @Test
    public void shouldReturnFalseIfLibraryNumberIsInValid() {
        User user1 = new User("Saisree", "S", "user", name, emailID, mobileNumber);
        assertFalse(user1.hasValidLibraryNumber());
    }

    @Test
    public void shouldReturnRoleOfUser() {
        User user1 = new User("Saisree", "S", "user", name, emailID, mobileNumber);
        assertEquals("user", user1.getRole());
    }

    @Test
    public void shouldReturnToStringFormatOfUserDetails(){
        User user1 = new User("Sai-sree", "S", "user", name, emailID, mobileNumber);
        System.out.println(user1.toString());
        assertEquals("libraryNumber='Sai-sree', role='user', name='sai', emailID='sai@email.com', mobileNumber='7660029504'\n",user1.toString());
    }


}