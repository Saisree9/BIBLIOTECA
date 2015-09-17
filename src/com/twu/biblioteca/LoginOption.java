package com.twu.biblioteca;

public class LoginOption implements MainMenuOption {
    private Console console;
    private Library library;
    private Authenticator authenticator;
    private User user;
    private MovieStore movieStore;

    public LoginOption(Console console, Library library, MovieStore movieStore, Authenticator authenticator) {
        this.console = console;
        this.library = library;
        this.movieStore = movieStore;
        this.authenticator = authenticator;
    }

    @Override
    public void doOperation() {
        user=authenticateUserDetails();
    }

    public User authenticateUserDetails() {
        String libraryNumber = console.getUserInput();
        String passWord = console.getUserInput();
        return authenticator.authenticate(libraryNumber,passWord);
    }
}