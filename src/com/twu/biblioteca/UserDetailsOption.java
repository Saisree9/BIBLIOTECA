package com.twu.biblioteca;

import java.util.List;

public class UserDetailsOption implements MainMenuOption {
    private  User user;
    private Console console;

    public UserDetailsOption(User user,Console console) {
        this.user = user;
        this.console=console;
    }

    @Override
    public void doOperation() {
        console.display(user.toString());
    }
}
