package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class DisplayTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    public void shouldDisplayWelcomeMessage() {
        System.setOut(new PrintStream(output));
        Display display = mock(Display.class);
        display.display("WELCOME TO PUBLIC LIBRARY");
        Mockito.verify(display, times(1)).display("WELCOME TO PUBLIC LIBRARY");
    }
}