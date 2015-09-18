package com.twu.biblioteca;

public class DefaultMainMenuOptionsDelegator implements MainMenuOptionDelegator {

    private Authenticator authenticator;
    private MainMenuOptionDelegator mainMenuOptionDelegator;

    public DefaultMainMenuOptionsDelegator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public MainMenuOption getMainMenuOption(Console console, Library library, MovieStore movieStore) {
        int option = Integer.parseInt(console.getUserInput());
        switch (option) {
            case 1:
                return new ListBooksOption(library, console);
            case 2:
                return new Quit();
            case 3:
                return new LoginOption(console, library, movieStore, authenticator,mainMenuOptionDelegator);
            case 4:
                return new ListMoviesOption(console, movieStore);
            case 5:
                return new CheckOutMovieOption(console, movieStore);
            default:
                return new InvalidMenuOption(console);
        }
    }
}
