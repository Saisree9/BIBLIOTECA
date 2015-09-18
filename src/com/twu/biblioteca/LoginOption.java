package com.twu.biblioteca;

public class LoginOption implements MainMenuOption {
    private Console console;
    private Library library;
    private Authenticator authenticator;
    private User user;
    private MovieStore movieStore;
    DelegatorFactory delegatorFactory;

    public LoginOption(Console console, Library library, MovieStore movieStore, Authenticator authenticator, DelegatorFactory delegatorFactory) {
        this.console = console;
        this.library = library;
        this.movieStore = movieStore;
        this.authenticator = authenticator;
        this.delegatorFactory = delegatorFactory;
    }

    @Override
    public void doOperation() {
        user = authenticateUserDetails();
//        if (user != null) {
        MainMenuOptionDelegator mainMenuOptionDelegator = delegatorFactory.getMainMenuOptionDelegator(user);
        MainMenuOption mainMenuOption = mainMenuOptionDelegator.getMainMenuOption(console, library, movieStore);
        mainMenuOption.doOperation();

    }
    public User authenticateUserDetails() {
        String libraryNumber = console.getUserInput();
        String passWord = console.getUserInput();
        return authenticator.authenticate(libraryNumber, passWord);
    }
}