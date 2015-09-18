package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookDetailsTest {
    @Test
    public void shouldReturnToStringFormatOfBookDetails() {
        BookDetails bookDetails = new BookDetails(new Book("Head First Java", "bert", 1988), new User("111-2222", "3", "user", "sai", "sai@gmail.com", "7660029504"));
        assertEquals("Book\n"+"Title: Head First Java', Author: bert', YearPublished: 1988\n" +"\n"+"User\n"+
                "libraryNumber='111-2222', role='user', name='sai', emailID='sai@gmail.com', mobileNumber='7660029504'\n", bookDetails.toString());
    }
}