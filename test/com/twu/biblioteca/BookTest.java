package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldReturnToStringFormatOfBook() {
        Book book = new Book("Head First Java", "Bert", 1991);
        assertEquals("Book{" +
                "title='" + "Head First Java" + '\'' +
                ", author='" + "Bert" + '\'' +
                ", yearPublished=" + 1991 +
                '}' + "\n", book.toString());
    }

    @Test
    public void shouldEqualToItself() {
        Book book = new Book("Head First Java", "Bert", 1991);
        assertEquals(book, book);
    }

    @Test
    public void shouldNotEqualToNull() {
        Book book = new Book("Head First Java", "Bert", 1991);
        assertNotEquals(book, null);
    }

    @Test
    public void shouldEqualToBookWhichHasSameProperties() {
        Book book1 = new Book("Head First Java", "Bert", 1991);
        Book book2 = new Book("Head First Java", "Bert", 1991);
        assertEquals(book1, book2);

    }

}