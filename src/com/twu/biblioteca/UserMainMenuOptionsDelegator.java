package com.twu.biblioteca;

public class UserMainMenuOptionsDelegator implements MainMenuOptionDelegator {

    public MainMenuOption getMainMenuOption(Console console, Library library, MovieStore movieStore) {
        int option = Integer.parseInt(console.getUserInput());
        switch (option) {
            case 1:
                return new ListBooksOption(library, console);
            default:
                return new InvalidMenuOption(console);
        }
    }
}
