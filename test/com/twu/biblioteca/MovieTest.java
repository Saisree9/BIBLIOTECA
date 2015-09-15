package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void shouldEqualToItself() {
        Movie movie = new Movie("Matrix", "SomeOne", 2000, 3.4);

        assertEquals(movie, movie);
    }

    @Test
    public void shouldEqualToMovieHasSameNameAndDirector() {
        Movie movie1 = new Movie("Matrix", "SomeOne", 2000, 3.4);
        Movie movie2 = new Movie("Matrix", "SomeOne", 2001, 3.8);

        assertEquals(movie1, movie2);
    }

    @Test
    public void shouldNotEqualToNull() {
        Movie movie1 = new Movie("Matrix", "SomeOne", 2000, 3.4);
        assertNotEquals(null, movie1);

    }

    @Test
    public void shouldEqualToMovieWhichHasSameProperties() {
        Movie movie1 = new Movie("Matrix", "SomeOne", 2000, 3.4);
        Movie movie2 = new Movie("Matrix", "SomeOne", 2000, 3.4);
        assertEquals(movie1, movie2);

    }

}