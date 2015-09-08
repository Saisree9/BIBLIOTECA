package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Biblioteca application start the LibrarySystem
public class BibliotecaApp {

    private List<Book> listOfBooks = new ArrayList<Book>();
    private MainMenu mainMenu;


    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Console console = new Console();
        bibliotecaApp.start(console);
    }

    public void start(Console console) {
        console.display("WELCOME TO PUBLIC LIBRARY\n");
        listOfBooks.add(new Book("Java design patterns", "pankaj", 1887));
        listOfBooks.add(new Book("Head First Java", "Bert", 1991));
        Library library = new Library(listOfBooks);
        while (true) {
            console.display("Option1:ListBooks\nOption2:Quit\nEnterTheOption:");
            mainMenu = getMainMenuWithOption(console);
            mainMenu.doOperation(library, console);
        }
    }

    public MainMenu getMainMenuWithOption(Console console) {
        int option = console.getUserInput();
        switch (option) {
            case 1:
                mainMenu = new MainMenu(new ListBooksOption());
                break;
            case 2:
                mainMenu = new MainMenu(new Quit());
                break;
            default:
                mainMenu = new MainMenu(new InvalidMenuOption());
        }
        return mainMenu;
    }
}
