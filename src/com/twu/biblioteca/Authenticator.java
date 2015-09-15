package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Authenticator {
    private List<User> listOfUsers = new ArrayList<User>();

    public Authenticator(List<User> users) {
        this.listOfUsers = users;
    }

    public boolean authenticate(User user){
        return listOfUsers.contains(user);
    }
}
