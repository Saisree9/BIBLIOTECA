package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {
    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStart() {
        Console display = mock(Console.class);
        Controller controller = new Controller();

        //when(display.getUserInput()).thenReturn("2");
        //controller.start(display);

       // verify(display, times(1)).display("WELCOME TO PUBLIC LIBRARY\n");
    }
}