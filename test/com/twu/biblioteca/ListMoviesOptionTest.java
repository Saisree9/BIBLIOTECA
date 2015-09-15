package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMoviesOptionTest {
    private List<Movie> movies = new ArrayList<Movie>();
    private Movie movie1 = new Movie("Movie1", "director1", 1, 1);
    private Movie movie2 = new Movie("Movie2", "director2", 2, 2);

    @Test
    public void shouldDisplayListOfMoviesPresentInMovieStore() {
        movies.add(movie1);
        movies.add(movie2);
        MovieStore movieStore = new MovieStore(movies);
        Console console = mock(Console.class);
        MainMenuOption listMoviesOption = new ListMoviesOption(console, movieStore);
        listMoviesOption.doOperation();
        verify(console).display(movieStore.toString());
    }
}