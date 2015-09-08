package com.twu.biblioteca;

public class MainMenu {
    MainMenuOption mainMenuOption;

    public MainMenu(MainMenuOption mainMenuOption) {
        this.mainMenuOption = mainMenuOption;
    }

    public void doOperation(Library library, Console console) {
        mainMenuOption.doOperation(library, console);
    }
}
