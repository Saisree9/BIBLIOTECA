package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MovieStore {
    private List<Movie> availableMovies;
    private List<Movie> checkOutMovieList=new ArrayList<Movie>();

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

    public boolean isMovieExist(Movie movie) {
        for (Movie movie1 : availableMovies) {
            if (movie.equals(movie1)) {
                checkOutMovieList.add(movie1);
                return true;
            }
        }
        return false;
    }

}
