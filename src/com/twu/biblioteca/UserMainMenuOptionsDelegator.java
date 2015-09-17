package com.twu.biblioteca;

public class UserMainMenuOptionsDelegator implements MainMenuOptionDelegator {

    private User user;

    public UserMainMenuOptionsDelegator(User user) {
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
            case 4:
                return new ReturnBookOption(library, console);
            case 5:
                return new ListMoviesOption(console, movieStore);
            case 6:
                return new CheckOutMovieOption(console, movieStore);
            default:
                return new InvalidMenuOption(console);
        }
    }
}
