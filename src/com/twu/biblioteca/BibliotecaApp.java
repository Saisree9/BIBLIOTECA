package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Biblioteca application start the LibrarySystem
public class BibliotecaApp {

    List<Book> listOfBooks = new ArrayList<Book>();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Display display = new Display();

        bibliotecaApp.start(display);
    }

    public void start(Display display) {
        display.display("WELCOME TO PUBLIC LIBRARY\n");
        listOfBooks.add(new Book("Java design patterns", "pankaj", 1887));
        listOfBooks.add(new Book("Head First Java", "Bert", 1991));
        Library library = new Library(listOfBooks);
        display.display(library.toString());
    }

}
