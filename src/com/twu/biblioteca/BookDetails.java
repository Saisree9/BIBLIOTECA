package com.twu.biblioteca;

public class BookDetails {
    private Book book;
    private User user;

    public BookDetails(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Book\n" + book + "\n" + "User\n" + user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDetails that = (BookDetails) o;

        return this.book.equals(that.book) && this.user.equals(that.user);

    }
}
