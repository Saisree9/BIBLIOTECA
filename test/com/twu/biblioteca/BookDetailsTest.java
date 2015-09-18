package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookDetailsTest {
    @Test
    public void shouldReturnToStringFormatOfBookDetails() {
        BookDetails bookDetails = new BookDetails("Head First Java", "111-2222");
        System.out.println(bookDetails.toString());
        assertEquals("bookTitle='Head First Java', libraryNumber='111-2222'", bookDetails.toString());
    }
}