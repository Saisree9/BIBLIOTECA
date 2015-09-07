package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class ConsoleTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    public void shouldDisplayWelcomeMessage() {
        System.setOut(new PrintStream(output));
        Console displayWelcomeMessage = mock(Console.class);
        displayWelcomeMessage.display("WELCOME TO PUBLIC LIBRARY");
        Mockito.verify(displayWelcomeMessage, times(1)).display("WELCOME TO PUBLIC LIBRARY");
    }

    @Test
    public void shouldDisplayBookDetails() {
        System.setOut(new PrintStream(output));
        Console displayBookDetails = mock(Console.class);
        displayBookDetails.display("Harry Potter");
        Mockito.verify(displayBookDetails, times(1)).display("Harry Potter");
    }

    @Test
    public void shouldReadInputFromUser() {
        String userInput = "1";
        Console input = mock(Console.class);
        when(input.getUserInput()).thenReturn(userInput);
        assertEquals(userInput, input.getUserInput());
    }
}