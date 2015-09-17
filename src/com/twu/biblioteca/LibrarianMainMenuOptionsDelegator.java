package com.twu.biblioteca;

public class LibrarianMainMenuOptionsDelegator implements MainMenuOptionDelegator {

    private User user;

    public LibrarianMainMenuOptionsDelegator(User user) {
        this.user = user;
    }

    public MainMenuOption getMainMenuOption(Console console, Library library, MovieStore movieStore) {
        int option = Integer.parseInt(console.getUserInput());
        switch (option) {
            case 1:
                return new ListBooksOption(library, console);
            case 2:
                return new UserDetailsOption(user, console);
            case 3:
                return new CheckOutBookOption(library, console);
            default:
                return new InvalidMenuOption(console);
        }
    }

}
