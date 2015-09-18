package com.twu.biblioteca;
//invalid operation
public class InvalidMenuOption implements MainMenuOption {

    private Console console;

    public InvalidMenuOption(Console console) {
        this.console = console;
    }

    @Override
    public void doOperation() {
        console.display("Select a valid option\n");
    }
}
