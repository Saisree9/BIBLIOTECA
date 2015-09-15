package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MovieStore {
    private List<Movie> availableMovies;

    public MovieStore(List<Movie> movies) {
        this.availableMovies = movies;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object movie : availableMovies) {
            stringBuilder.append(movie.toString());
        }
        return stringBuilder.toString();
    }
}
