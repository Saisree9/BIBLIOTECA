package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Biblioteca application start the LibrarySystem
public class BibliotecaApp {

    List<Book> listOfBooks = new ArrayList<Book>();

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
        String option = selectOption(console);
        if (option.equals("1"))
            console.display(library.toString());

    }

    public String selectOption(Console console) {
        console.display("Option1:ListBooks\nEnter the option:");
        return console.getUserInput();
    }

}
