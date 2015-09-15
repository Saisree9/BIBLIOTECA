package com.twu.biblioteca;

//Biblioteca application start the LibrarySystem
public class BibliotecaApp {

    public static void main(String[] args) {
        Console console = new Console();
        Controller controller = new Controller();
        controller.start(console);
    }
}