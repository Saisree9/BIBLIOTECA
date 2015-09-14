package com.twu.biblioteca;

public class ListBooksOption implements MainMenuOption {
    private Library library;
    private Console console;

    public ListBooksOption(Library library, Console console) {
        this.library = library;
        this.console = console;
    }

    @Override
    public void doOperation() {
        console.display(library.toString());
    }
}
