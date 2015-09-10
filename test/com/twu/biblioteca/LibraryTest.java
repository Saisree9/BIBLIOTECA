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
    private Library library;

    @Before
    public void setUp() {
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        library = new Library(listOfBooks);
    }

    @Test
    public void shouldReturnToStringFormatOfListOfBooks() {

        assertEquals("title='" + "Java design patterns" + '\'' + ", author='" + "pankaj" + '\'' + ", yearPublished=" + 1887 + "\n" + "title='" + "Head First Java" + '\'' + ", author='" + "Bert" + '\'' + ", yearPublished=" + 1991 + "\n", library.toString());
    }

    @Test
    public void shouldReturnTrueIfBookExistInTheLibrary() {
        assertEquals(true, library.isBookExist(new Book("Java design patterns", "pankaj", 1887)));
    }

    @Test
    public void shouldRemoveBookFromTheLibraryIfBookIsCheckedOut() {
        library.checkOut(book1);
        assertFalse(listOfBooks.contains(book1));
    }

    @Test
    public void shouldReturnMessageAfterRemovingBookFromTheLibraryIfBookIsSuccessfullyCheckedOut() {
        String returnMessage = library.checkOut(book1);
        assertEquals("Thank you ! Enjoy the book\n", returnMessage);
    }

    @Test
    public void shouldReturnMessageIfBookIsUnsuccessfullyCheckedOut() {
        String returnMessage = library.checkOut(new Book("java", "kent", 1990));
        assertEquals("That book is not available\n", returnMessage);
    }

    @Test
    public void shouldReturnMessageAfterRemovingBookwhichHasEqualTitleIfBookIsSuccessfullyCheckedOut() {
        Book book = new Book("Java design patterns", "UNKNOWN_AUTHOR", 0);
        String returnMessage = library.checkOut(book);
        assertEquals("Thank you ! Enjoy the book\n", returnMessage);
    }
}