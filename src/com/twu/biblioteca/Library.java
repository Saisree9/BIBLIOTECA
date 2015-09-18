package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
//library is to check out book ,displays list of book details
public class Library {
    private List<Book> availableBookList;
    private List<Book> checkOutBookList = new ArrayList<Book>();
    private List<BookDetails> listOfBookDetails = new ArrayList<>();

    public Library(List<Book> books) {
        this.availableBookList = books;
    }

    public boolean isBookExist(Book searchingBook, User user) {
        for (Book book : availableBookList) {
            if (book.equals(searchingBook)) {
                checkOutBookList.add(book);
                listOfBookDetails.add(new BookDetails(book, user));
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------------------------------------------------------------\n");
        for (Object book : availableBookList) {
            stringBuilder.append(book.toString());
        }
        stringBuilder.append("------------------------------------------------------------------------------\n");

        return stringBuilder.toString();
    }


    public String checkOutBook(Book book, User user) {
        if (isBookExist(book, user)) {
            availableBookList.remove(book);
            return "Thank you ! Enjoy the book\n";
        }
        return "That book is not available\n";
    }

    public String returnBook(Book book, User user) {
        if (isBookExistInCheckOutBookList(book, user)) {
            checkOutBookList.remove(book);
            return "Thank You ! for returning book\n";
        }
        return "That is not a valid book to return\n";
    }

    private boolean isBookExistInCheckOutBookList(Book checkOutBook, User user) {
        for (Book book : checkOutBookList) {
            if (book.equals(checkOutBook)) {
                availableBookList.add(book);
                listOfBookDetails.remove(new BookDetails(book, user));
                return true;
            }
        }
        return false;
    }

    public StringBuilder displayBookDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        for (BookDetails bookDetails : listOfBookDetails) {
            stringBuilder.append(bookDetails);
        }
        return stringBuilder;
    }
}