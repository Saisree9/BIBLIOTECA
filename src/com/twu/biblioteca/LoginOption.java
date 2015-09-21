package com.twu.biblioteca;

public class LoginOption implements MainMenuOption {
    private Console console;
    private Library library;
    private Authenticator authenticator;
    private MovieStore movieStore;
    private DelegatorFactory delegatorFactory;

    public LoginOption(Console console, Library library, MovieStore movieStore, Authenticator authenticator, DelegatorFactory delegatorFactory) {
        this.console = console;
        this.library = library;
        this.movieStore = movieStore;
        this.authenticator = authenticator;
        this.delegatorFactory = delegatorFactory;
    }

    @Override
    public void doOperation() {
        User user = authenticateUserDetails();
        while (true) {
            if (user != null) {
                MainMenuOptionDelegator mainMenuOptionDelegator = delegatorFactory.getMainMenuOptionDelegator(user);
                MainMenuOption mainMenuOption = mainMenuOptionDelegator.getMainMenuOption(console, library, movieStore);
                mainMenuOption.doOperation();
            } else {
                console.display("Authentication failed");
                break;
            }
        }
    }

    private User authenticateUserDetails() {
        console.display("Enter library number: \n");
        String libraryNumber = console.getUserInput();
        console.display("Enter password: \n");
        String passWord = console.getUserInput();
        return authenticator.authenticate(libraryNumber, passWord);
    }
}