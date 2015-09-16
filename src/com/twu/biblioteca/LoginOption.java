package com.twu.biblioteca;

public class LoginOption implements MainMenuOption {
    private Console console;
    private Library library;
    private Authenticator authenticator;
    private User user;

    public LoginOption(Console console, Library library) {
        this.console = console;
        this.library = library;
    }

    @Override
    public void doOperation() {
        String libraryNumber = console.getUserInput();
        String password = console.getUserInput();
        user = new User(libraryNumber, password);
    }
}
