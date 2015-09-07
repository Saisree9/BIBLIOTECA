package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List listOfBooks;

    public Library(List list) {
        this.listOfBooks = list;
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
