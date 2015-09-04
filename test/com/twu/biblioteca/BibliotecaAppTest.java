package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class BibliotecaAppTest {
    @Test
    public void shouldDisplayWelcomeMessageApplicationStart() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Display display = mock(Display.class);
        bibliotecaApp.start(display);
        Mockito.verify(display, times(1)).display("WELCOME TO PUBLIC LIBRARY");
    }
}