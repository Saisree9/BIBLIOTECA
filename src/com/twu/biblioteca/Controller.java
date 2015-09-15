package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private Delegator delegator = new Delegator();
    private List<Movie> listOfMovies = new ArrayList<Movie>();

    public void start(Console console) {
        console.display("WELCOME TO PUBLIC LIBRARY\n");
        listOfBooks.add(new Book("Java design patterns", "pankaj", 1887));
        listOfBooks.add(new Book("Head First Java", "Bert", 1991));
        listOfMovies.add(new Movie("One", "SS", 2001, 5.7));
        listOfMovies.add(new Movie("Ones", "SD", 2001, 5.6));
        Library library = new Library(listOfBooks);
        MovieStore movieStore = new MovieStore(listOfMovies);
        while (true) {
            console.display("Option1:ListBooks\nOption2:Quit\nOption3:CheckOut\nOption4:Return\nOption5:ListMovies\nOption6:CheckOutMovie\nEnterTheOption:");
            MainMenuOption mainMenuOption = delegator.getMainMenuOption(console, library, movieStore);
            mainMenuOption.doOperation();
        }
    }
}
