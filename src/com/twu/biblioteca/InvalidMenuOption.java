package com.twu.biblioteca;

public class InvalidMenuOption implements MainMenuOption {

    @Override
    public void doOperation(Library library, Console console) {
        console.display("Select a valid option\n");
    }
}
