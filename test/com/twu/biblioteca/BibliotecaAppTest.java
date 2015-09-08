package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStart() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Console display = mock(Console.class);

        when(display.getUserInput()).thenReturn(2);
        bibliotecaApp.start(display);

        verify(display, times(1)).display("WELCOME TO PUBLIC LIBRARY\n");
    }


}

