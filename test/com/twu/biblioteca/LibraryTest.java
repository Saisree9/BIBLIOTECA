package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class LibraryTest {
    @Test
    public void shouldReturnToStringFormatOfListOfBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Java design patterns", "pankaj", 1887));
        listOfBooks.add(new Book("Head First Java", "Bert", 1991));
        Library library = new Library(listOfBooks);
        assertEquals("Book{" + "title='" + "Java design patterns" + '\'' + ", author='" + "pankaj" + '\'' + ", yearPublished=" + 1887 + '}' + "\n" + "Book{" + "title='" + "Head First Java" + '\'' + ", author='" + "Bert" + '\'' + ", yearPublished=" + 1991 + '}' + "\n", library.toString());
    }
}