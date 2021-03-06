package com.twu.biblioteca;

public class NormalUserMainMenuOptionsDelegator implements MainMenuOptionDelegator {

    private User user;

    public NormalUserMainMenuOptionsDelegator(User user) {
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
                return new CheckOutBookOption(library, console, user);
            case 4:
                return new ReturnBookOption(library, console, user);
            case 5:
                return new ListMoviesOption(console, movieStore);
            case 6:
                return new CheckOutMovieOption(console, movieStore);
            case 7:
                return new LogOutOption(console);
            default:
                return new InvalidMenuOption(console);
        }
    }
}
