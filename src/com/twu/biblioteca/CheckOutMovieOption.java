package com.twu.biblioteca;

public class CheckOutMovieOption implements MainMenuOption {
    private Console console;
    private MovieStore movieStore;

    public CheckOutMovieOption(Console console, MovieStore movieStore) {
        this.console = console;
        this.movieStore = movieStore;
    }

    @Override
    public void doOperation() {
        console.display("Enter movie name to checkout: ");
        String movieName = console.getUserInput();
        Movie movie = new Movie(movieName, "UNKNOWN_DIRECTOR", 0, 0);
        movieStore.checkOutMovie(movie);
    }
}
