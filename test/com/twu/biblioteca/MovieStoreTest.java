package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MovieStoreTest {
    private List<Movie> movies = new ArrayList<Movie>();
    private Movie movie1 = new Movie("Movie1", "director1", 1, 1);
    private Movie movie2 = new Movie("Movie2", "director2", 2, 2);
    private MovieStore movieStore;

    @Before
    public void setUp() {
        movies.add(movie1);
        movies.add(movie2);
        movieStore = new MovieStore(movies);
    }

    @Test
    public void shouldReturnToStringFormatOfTheListOfMovies() {
        assertEquals("name='Movie1', director='director1', year=1, rating=1.0\nname='Movie2', director='director2', year=2, rating=2.0\n",movieStore.toString());
    }
}