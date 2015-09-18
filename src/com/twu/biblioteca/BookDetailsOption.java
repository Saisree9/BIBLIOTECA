package com.twu.biblioteca;

public class BookDetailsOption implements MainMenuOption {

    private Console console;
    private Library library;

    public BookDetailsOption(Console console, Library library) {
        this.console = console;
        this.library = library;
    }

    @Override
    public void doOperation() {
        console.display(String.valueOf(library.displayBookDetails()));
    }
}
