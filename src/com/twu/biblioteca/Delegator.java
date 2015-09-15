package com.twu.biblioteca;

public class Delegator {

    public MainMenuOption getMainMenuOption(Console console, Library library) {
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
            default:
                return new InvalidMenuOption(console);
        }
    }
}
