package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Authenticator is to authenticate the input user credentials
public class Authenticator {
    private List<User> users = new ArrayList<User>();

    public Authenticator(List<User> users) {
        this.users = users;
    }

    public User authenticate(String libraryNumber, String password) {
        User user = new User(libraryNumber, password, "NULL");
        for (User user1 : users) {
            if (user.equals(user1))
                return user;
        }
        return null;
    }
}
