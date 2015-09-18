package com.twu.biblioteca;

public class LogOutOption implements MainMenuOption {
    private Console console;

    public LogOutOption(Console console) {
        this.console = console;
    }

    @Override
    public void doOperation() {
        Controller controller = new Controller();
        controller.start(console);
    }
}
