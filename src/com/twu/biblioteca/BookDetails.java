package com.twu.biblioteca;

public class BookDetails {
    private String bookTitle;
    private String libraryNumber;

    public BookDetails(String bookTitle, String libraryNumber) {
        this.bookTitle = bookTitle;
        this.libraryNumber = libraryNumber;
    }

    @Override
    public String toString() {
        return "bookTitle='" + bookTitle + '\'' +
                ", libraryNumber='" + libraryNumber + '\'';
    }
}
