package com.twu.biblioteca;

public class Quit implements MainMenuOption{
    @Override
    public void doOperation(Library library, Console console) {
        System.exit(0);
    }
}
