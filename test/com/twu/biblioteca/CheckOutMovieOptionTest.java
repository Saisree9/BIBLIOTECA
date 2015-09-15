package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutMovieOptionTest {
    private List<Movie> movies = new ArrayList<Movie>();
    private Movie movie1 = new Movie("Movie1", "director1", 1, 1);
    private Movie movie2 = new Movie("Movie2", "director2", 2, 2);
    private MainMenuOption checkOutMovieOption;
    MovieStore movieStore;


    @Before
    public void setUp() {
        movies.add(movie1);
        movies.add(movie2);
        movieStore = new MovieStore(movies);


        checkOutMovieOption = mock(CheckOutMovieOption.class);
    }

    @Test
    public void shouldAskForMovieName() {
        Console console = mock(Console.class);
        checkOutMovieOption = new CheckOutMovieOption(console, movieStore);
        when(console.getUserInput()).thenReturn("Movie1");

        checkOutMovieOption.doOperation();

        verify(console).display("Enter movie name to checkout: ");
    }

    @Test
    public void shouldDoCheckOutMovieOperationWhenCalled() {
        Console console = mock(Console.class);
        checkOutMovieOption = mock(CheckOutMovieOption.class);

        when(console.getUserInput()).thenReturn("Movie1");

        checkOutMovieOption.doOperation();

        verify(checkOutMovieOption).doOperation();
    }
}