package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LibraryTest {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();
    private Book book1 = new Book("Java design patterns", "pankaj", 1887);
    private Book book2 = new Book("Head First Java", "Bert", 1991);
    private Library library;

    @Before
    public void setUp() {
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        library = new Library(listOfBooks);
    }

    @Test
    public void shouldReturnToStringFormatOfListOfBooks() {

        assertEquals("Book{" + "title='" + "Java design patterns" + '\'' + ", author='" + "pankaj" + '\'' + ", yearPublished=" + 1887 + '}' + "\n" + "Book{" + "title='" + "Head First Java" + '\'' + ", author='" + "Bert" + '\'' + ", yearPublished=" + 1991 + '}' + "\n", library.toString());
    }

    @Test
    public void shouldReturnTrueIfBookExistInTheLibrary() {
        assertEquals(true, library.isBookExist(new Book("Java design patterns", "pankaj", 1887)));
    }
}