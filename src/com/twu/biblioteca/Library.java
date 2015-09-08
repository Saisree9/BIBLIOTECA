package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> listOfBooks;

    public Library(List<Book> list) {
        this.listOfBooks = list;
    }

    public boolean isBookExist(Book searchingBook) {
     return listOfBooks.contains(searchingBook);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string;
        for (Object book : listOfBooks) {
            stringBuilder.append(book.toString());
        }
        string = new String(stringBuilder);
        return string;
    }
}
