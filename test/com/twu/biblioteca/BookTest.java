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
                '}'+"\n", book.toString());
    }

}