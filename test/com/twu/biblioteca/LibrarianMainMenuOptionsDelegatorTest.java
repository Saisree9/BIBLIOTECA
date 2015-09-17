package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibrarianMainMenuOptionsDelegatorTest {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private Console console = mock(Console.class);
    private Book book1 = new Book("Java design patterns", "pankaj", 1887);
    private Book book2 = new Book("Head First Java", "Bert", 1991);
    private Library library;
    private MainMenuOptionDelegator delegator;
    private List<Movie> movies = new ArrayList<Movie>();
    private Movie movie1 = new Movie("Movie1", "director1", 1, 1);
    private Movie movie2 = new Movie("Movie2", "director2", 2, 2);
    private MovieStore movieStore;
    private User user;
    private MainMenuOption mainMenuOption;

    @Before
    public void setUp() {
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        library = new Library(listOfBooks);
        movies.add(movie1);
        movies.add(movie2);
        movieStore = new MovieStore(movies);
        delegator = new LibrarianMainMenuOptionsDelegator(user);
    }

    @Test
    public void shouldGetOptionInputFromUser() {
        when(console.getUserInput()).thenReturn("1");

        delegator.getMainMenuOption(console, library, movieStore);

        verify(console).getUserInput();
    }

    @Test
    public void shouldReturnMainMenuListBooksOptionWhenOptionOneIsSelected() {
        when(console.getUserInput()).thenReturn("1");

        mainMenuOption = delegator.getMainMenuOption(console, library, movieStore);

        assertEquals(mainMenuOption.getClass(), ListBooksOption.class);
    }

    @Test
    public void shouldReturnMainMenuInvalidOptionWhenInvalidOptionIsSelected() {
        when(console.getUserInput()).thenReturn("10");

        mainMenuOption = delegator.getMainMenuOption(console, library, movieStore);

        assertEquals(mainMenuOption.getClass(), InvalidMenuOption.class);

    }

    @Test
    public void shouldReturnMainMenuUserDetailsOptionWhenOptionOptionTwoIsSelected() {
        when(console.getUserInput()).thenReturn("2");

        mainMenuOption = delegator.getMainMenuOption(console, library, movieStore);

        assertEquals(mainMenuOption.getClass(), UserDetailsOption.class);
    }

    @Test
    public void shouldReturnMainMenuCheckOutBookOptionWhenOptionThreeIsSelected() {
        when(console.getUserInput()).thenReturn("3");

        mainMenuOption = delegator.getMainMenuOption(console, library, movieStore);

        assertEquals(mainMenuOption.getClass(), CheckOutBookOption.class);
    }

    @Test
    public void shouldReturnMainMenuReturnBookOptionWhenOptionThreeIsSelected() {
        when(console.getUserInput()).thenReturn("4");

        mainMenuOption = delegator.getMainMenuOption(console, library, movieStore);

        assertEquals(mainMenuOption.getClass(), ReturnBookOption.class);
    }

    @Test
    public void shouldReturnMainMenuListMoviesOptionWhenOptionFiveIsSelected() {
        when(console.getUserInput()).thenReturn("5");

        mainMenuOption = delegator.getMainMenuOption(console, library, movieStore);

        assertEquals(mainMenuOption.getClass(), ListMoviesOption.class);
    }

    @Test
    public void shouldReturnMainMenuCheckOutMovieOptionWhenOptionFiveIsSelected() {
        when(console.getUserInput()).thenReturn("6");

        mainMenuOption = delegator.getMainMenuOption(console, library, movieStore);

        assertEquals(mainMenuOption.getClass(), CheckOutMovieOption.class);
    }

    @Test
    public void shouldReturnMainMenuBookDetailsOptionWhenOptionSixIsSelected() {
        when(console.getUserInput()).thenReturn("7");

        mainMenuOption = delegator.getMainMenuOption(console, library, movieStore);

        assertEquals(mainMenuOption.getClass(), BookDetailsOption.class);
    }


}