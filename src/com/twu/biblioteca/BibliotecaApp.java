package com.twu.biblioteca;

//Biblioteca application start/run the LibrarySystem
public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Display display = new Display();
        bibliotecaApp.start(display);
    }

    public void start(Display display) {
        display.display("WELCOME TO PUBLIC LIBRARY");
    }

}
