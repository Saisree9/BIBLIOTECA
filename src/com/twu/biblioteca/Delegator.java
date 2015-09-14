package com.twu.biblioteca;

public class Delegator {

    MainMenu mainMenu;

    public MainMenu getMainMenuWithOption(Console console,Library library) {
        int option = Integer.parseInt(console.getUserInput());
        switch (option) {
            case 1:
                mainMenu = new MainMenu(new ListBooksOption(library,console));
                break;
            case 2:
                mainMenu = new MainMenu(new Quit());
                break;
            case 3:
                mainMenu = new MainMenu(new CheckOutOption(library,console));
                break;
            case 4:
                mainMenu = new MainMenu(new ReturnOption(library,console));
                break;
            default:
                mainMenu = new MainMenu(new InvalidMenuOption(console));
        }
        return mainMenu;
    }
}
