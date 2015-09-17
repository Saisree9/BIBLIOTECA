package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final ByteArrayInputStream inputStream = new ByteArrayInputStream("something".getBytes());

    @Test
    public void shouldDisplayWelcomeMessage() {
        System.setOut(new PrintStream(output));
        Console displayWelcomeMessage = new Console();
        displayWelcomeMessage.display("WELCOME TO PUBLIC LIBRARY");

        assertEquals("WELCOME TO PUBLIC LIBRARY", output.toString());
    }

    @Test
    public void shouldReadInputFromUser() {
        System.setIn(inputStream);
        Console input = new Console();
        assertEquals("something", input.getUserInput());
    }
}