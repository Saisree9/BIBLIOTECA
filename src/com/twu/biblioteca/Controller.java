package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private List<User> listOfUsers = new ArrayList<>();
    private List<Movie> listOfMovies = new ArrayList<Movie>();

    public void start(Console console) {
        console.display("WELCOME TO PUBLIC LIBRARY\n");
        listOfBooks.add(new Book("Java design patterns", "pankaj", 1887));
        listOfBooks.add(new Book("Head First Java", "Bert", 1991));
        listOfMovies.add(new Movie("One", "SS", 2001, 5.7));
        listOfMovies.add(new Movie("Ones", "SD", 2001, 5.6));
        listOfUsers.add(new User("111-2222", "3", "user"));
        listOfUsers.add(new User("112-2222", "3", "librarian"));
        Authenticator authenticator = new Authenticator(listOfUsers);
        Library library = new Library(listOfBooks);
        MovieStore movieStore = new MovieStore(listOfMovies);
        DelegatorFactory delegatorFactory = new DelegatorFactory(console, authenticator);
        DefaultMainMenuOptionsDelegator delegator = new DefaultMainMenuOptionsDelegator(authenticator, delegatorFactory);
        while (true) {
            console.display("Option1:ListBooks\n" +
                    "Option2:Quit\n" +
                    "Option3:Login\n" +
                    "Option4:ListMovies\n" +
                    "Option5:CheckOutMovie\n" +
                    "\nEnterTheOption:");
            MainMenuOption mainMenuOption = delegator.getMainMenuOption(console, library, movieStore);
            mainMenuOption.doOperation();
        }
    }
}
