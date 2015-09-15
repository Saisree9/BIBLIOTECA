package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LibraryTest {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();
    private Book book1 = new Book("Java design patterns", "pankaj", 1887);
    private Book book2 = new Book("Head First Java", "Bert", 1991);
    private Library bookLibrary;

    @Before
    public void setUp() {
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        bookLibrary = new Library(listOfBooks);
    }

    @Test
    public void shouldReturnToStringFormatOfListOfBooks() {

        assertEquals("title='" + "Java design patterns" + '\'' + ", author='" + "pankaj" + '\'' + ", yearPublished=" + 1887 + "\n" + "title='" + "Head First Java" + '\'' + ", author='" + "Bert" + '\'' + ", yearPublished=" + 1991 + "\n", bookLibrary.listBooks());
    }

    @Test
    public void shouldReturnTrueIfBookExistInTheLibrary() {
        assertEquals(true, bookLibrary.isBookExist(new Book("Java design patterns", "pankaj", 1887)));
    }

    @Test
    public void shouldRemoveBookFromTheLibraryIfBookIsCheckedOut() {
        bookLibrary.checkOutBook(book1);
        assertFalse(listOfBooks.contains(book1));
    }

    @Test
    public void shouldReturnMessageAfterRemovingBookFromTheLibraryIfBookIsSuccessfullyCheckedOut() {
        String returnMessage = bookLibrary.checkOutBook(book1);
        assertEquals("Thank you ! Enjoy the book\n", returnMessage);
    }

    @Test
    public void shouldReturnMessageIfBookIsUnsuccessfullyCheckedOut() {
        String returnMessage = bookLibrary.checkOutBook(new Book("java", "kent", 1990));
        assertEquals("That book is not available\n", returnMessage);
    }

    @Test
    public void shouldReturnMessageAfterRemovingBookwhichHasEqualTitleIfBookIsSuccessfullyCheckedOut() {
        Book book = new Book("Java design patterns", "UNKNOWN_AUTHOR", 0);
        String returnMessage = bookLibrary.checkOutBook(book);
        assertEquals("Thank you ! Enjoy the book\n", returnMessage);
    }

    @Test
    public void shouldReturnMessageAfterCheckingOutBookIfBookIsSuccessfullyReturned() {
        Book book = new Book("Java design patterns", "UNKNOWN_AUTHOR", 0);
        bookLibrary.checkOutBook(book);
        String returnMessage = bookLibrary.returnBook(book);
        assertEquals("Thank You ! for returning book\n", returnMessage);
    }

    @Test
    public void shouldReturnMessageAfterCheckingOutBookIfBookIsUnsuccessfullyReturned() {
        Book book = new Book("Java design", "UNKNOWN_AUTHOR", 0);
        bookLibrary.checkOutBook(book);
        String returnMessage = bookLibrary.returnBook(book);
        assertEquals("That is not a valid book to return\n", returnMessage);
    }
}