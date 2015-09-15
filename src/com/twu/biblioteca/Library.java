package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> availableBookList;
    private List<Book> checkOutBookList = new ArrayList<Book>();

    public Library(List<Book> books) {
        this.availableBookList = books;
    }

    public boolean isBookExist(Book searchingBook) {
        for (Book book : availableBookList) {
            if (book.equals(searchingBook)) {
                checkOutBookList.add(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object book : availableBookList) {
            stringBuilder.append(book.toString());
        }
        return stringBuilder.toString();
    }


    public String checkOutBook(Book book) {
        if (isBookExist(book)) {
            availableBookList.remove(book);
            return "Thank you ! Enjoy the book\n";
        }
        return "That book is not available\n";
    }

    public String returnBook(Book book) {
        if (isBookExistInCheckOutBookList(book)) {
            checkOutBookList.remove(book);
            return "Thank You ! for returning book\n";
        }
        return "That is not a valid book to return\n";
    }

    private boolean isBookExistInCheckOutBookList(Book checkOutBook) {
        for (Book book : checkOutBookList) {
            if (book.equals(checkOutBook)) {
                availableBookList.add(book);
                return true;
            }
        }
        return false;
    }

}