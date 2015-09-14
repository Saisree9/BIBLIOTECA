package com.twu.biblioteca;

public class MainMenu {
    MainMenuOption mainMenuOption;

    public MainMenu(MainMenuOption mainMenuOption) {
        this.mainMenuOption = mainMenuOption;
    }

    public void doOperation() {
        mainMenuOption.doOperation();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        MainMenu thatMainMenu = (MainMenu) that;

        return (thatMainMenu.mainMenuOption.getClass()).equals((this.mainMenuOption).getClass());

    }

}
