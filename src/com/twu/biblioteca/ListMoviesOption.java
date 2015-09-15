package com.twu.biblioteca;

public class ListMoviesOption implements MainMenuOption {
    Console console;
    MovieStore movieStore;

    public ListMoviesOption(Console console, MovieStore movieStore) {
        this.console = console;
        this.movieStore = movieStore;
    }

    @Override
    public void doOperation() {
        console.display(movieStore.toString());
    }
}
