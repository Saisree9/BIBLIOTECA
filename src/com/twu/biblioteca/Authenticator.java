package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Authenticator is to authenticate the input user credentials
public class Authenticator {
    private List<User> users = new ArrayList<User>();

    public Authenticator(List<User> users) {
        this.users = users;
    }

    public boolean authenticate(User user) {
        return users.contains(user);
    }
}
