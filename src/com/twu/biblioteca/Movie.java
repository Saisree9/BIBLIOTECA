package com.twu.biblioteca;

public class Movie {
    private String name;
    private String director;
    private int year;
    private double raitng;

    public Movie(String name, String director, int year, double raitng) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.raitng = raitng;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        Movie thatMovie = (Movie) that;

        return this.name.equals(thatMovie.name) && this.director.equals(thatMovie.director);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
