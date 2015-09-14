package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Biblioteca application start the LibrarySystem
public class BibliotecaApp {

    private List<Book> listOfBooks = new ArrayList<Book>();
    private Delegator delegator = new Delegator();


    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Console console = new Console();
        bibliotecaApp.start(console);
    }

    public void start(Console console) {
        MainMenu mainMenu;
        console.display("WELCOME TO PUBLIC LIBRARY\n");
        listOfBooks.add(new Book("Java design patterns", "pankaj", 1887));
        listOfBooks.add(new Book("Head First Java", "Bert", 1991));
        Library library = new Library(listOfBooks);
        while (true) {
            console.display("Option1:ListBooks\nOption2:Quit\nOption3:CheckOut\nOption4:Return\nEnterTheOption:");
            mainMenu = delegator.getMainMenuWithOption(console, library);
            mainMenu.doOperation();
        }
    }
}
