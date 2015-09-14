package com.twu.biblioteca;

public class Quit implements MainMenuOption {
    @Override
    public void doOperation() {
        System.exit(0);
    }
}
