package com.twu.biblioteca;

public class Delegator {

    public MainMenuOption getMainMenuOption(Console console, Library library, MovieStore movieStore) {
        int option = Integer.parseInt(console.getUserInput());
        switch (option) {
            case 1:
                return new ListBooksOption(library, console);
            case 2:
                return new Quit();
            case 3:
                return new CheckOutOption(library, console);
            case 4:
                return new ReturnOption(library, console);
            case 5:
                return new ListMoviesOption(console, movieStore);
            case 6:
                return new CheckOutMovieOption(console, movieStore);
            default:
                return new InvalidMenuOption(console);
        }
    }
}
