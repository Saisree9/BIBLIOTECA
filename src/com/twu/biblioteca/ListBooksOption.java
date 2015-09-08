package com.twu.biblioteca;

public class ListBooksOption implements MainMenuOption {

    @Override
    public void doOperation(Library library, Console console) {
        console.display(library.toString());
    }
}
