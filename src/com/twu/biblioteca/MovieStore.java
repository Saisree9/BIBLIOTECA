package com.twu.biblioteca;

import java.util.List;

public class MovieStore {
    private List<Movie> availableMovies;

    public MovieStore(List<Movie> movies) {
        this.availableMovies = movies;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------------------------------------------------------------\n");
        for (Object movie : availableMovies) {
            stringBuilder.append(movie.toString());
        }
        stringBuilder.append("------------------------------------------------------------------------------\n");
        return stringBuilder.toString();
    }

    public boolean isMovieExist(Movie movie) {
        for (Movie movie1 : availableMovies) {
            if (movie.equals(movie1)) {
                return true;
            }
        }
        return false;
    }

    public void checkOutMovie(Movie movie) {
        if (isMovieExist(movie))
            availableMovies.remove(movie);
    }

}
