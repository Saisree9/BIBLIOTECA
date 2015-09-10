package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> listOfBooks;

    public Library(List<Book> list) {
        this.listOfBooks = list;
    }

    public boolean isBookExist(Book searchingBook) {
        for (Book book : listOfBooks) {
            if (book.equals(searchingBook))
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object book : listOfBooks) {
            stringBuilder.append(book.toString());
        }
        return stringBuilder.toString();
    }

    public String checkOut(Book book) {
        if (isBookExist(book)) {
            listOfBooks.remove(book);
            return "Thank you ! Enjoy the book\n";
        }
        return "That book is not available\n";
    }
}