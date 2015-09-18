package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LibraryTest {
    private List<Book> books = new ArrayList<Book>();
    private Book book1 = new Book("Java design patterns", "pankaj", 1887);
    private Book book2 = new Book("Head First Java", "Bert", 1991);

    private Library library;
    private User user = new User("111-2222", "3", "user", "sai", "sai@gmail.com", "7660029504");

    @Before
    public void setUp() {
        books.add(book1);
        books.add(book2);
        library = new Library(books);
    }

    @Test
    public void shouldReturnToStringFormatOfListOfBooks() {

        assertEquals("------------------------------------------------------------------------------\n" +
                "Title: " + "Java design patterns" + '\'' + ", Author: " + "pankaj" + '\'' + ", YearPublished: " + 1887 + "\n" + "Title: " + "Head First Java" + '\'' + ", Author: " + "Bert" + '\'' + ", YearPublished: " + 1991 + "\n" +
                "------------------------------------------------------------------------------\n", library.toString());
    }

    @Test
    public void shouldReturnTrueIfBookExistInTheLibrary() {
        assertEquals(true, library.isBookExist(new Book("Java design patterns", "pankaj", 1887), user));
    }

    @Test
    public void shouldRemoveBookFromTheLibraryIfBookIsCheckedOut() {
        library.checkOutBook(book1, user);
        assertFalse(books.contains(book1));
    }

    @Test
    public void shouldReturnMessageAfterRemovingBookFromTheLibraryIfBookIsSuccessfullyCheckedOut() {
        String returnMessage = library.checkOutBook(book1, user);
        assertEquals("Thank you ! Enjoy the book\n", returnMessage);
    }

    @Test
    public void shouldReturnMessageIfBookIsUnsuccessfullyCheckedOut() {
        String returnMessage = library.checkOutBook(new Book("java", "kent", 1990), user);
        assertEquals("That book is not available\n", returnMessage);
    }

    @Test
    public void shouldReturnMessageAfterRemovingBookwhichHasEqualTitleIfBookIsSuccessfullyCheckedOut() {
        Book book = new Book("Java design patterns", "UNKNOWN_AUTHOR", 0);
        String returnMessage = library.checkOutBook(book, user);
        assertEquals("Thank you ! Enjoy the book\n", returnMessage);
    }

    @Test
    public void shouldReturnMessageAfterCheckingOutBookIfBookIsSuccessfullyReturned() {
        Book book = new Book("Java design patterns", "UNKNOWN_AUTHOR", 0);
        library.checkOutBook(book, user);
        String returnMessage = library.returnBook(book, user);
        assertEquals("Thank You ! for returning book\n", returnMessage);
    }

    @Test
    public void shouldReturnMessageAfterCheckingOutBookIfBookIsUnsuccessfullyReturned() {
        Book book = new Book("Java design", "UNKNOWN_AUTHOR", 0);
        library.checkOutBook(book, user);
        String returnMessage = library.returnBook(book, user);
        assertEquals("That is not a valid book to return\n", returnMessage);
    }

    @Test
    public void shouldReturnToStringFormatOfListOfBookDetails() {
        Book book = new Book("Java design", "UNKNOWN_AUTHOR", 0);
        library.checkOutBook(book, user);
        assertEquals("", library.displayBookDetails().toString());
    }


}