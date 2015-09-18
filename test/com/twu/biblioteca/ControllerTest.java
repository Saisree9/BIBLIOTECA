package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.mockito.Mockito.*;

public class ControllerTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStart() {
        Console display = mock(Console.class);
        Controller controller = new Controller();

        when(display.getUserInput()).thenReturn("2");

        exit.expectSystemExitWithStatus(0);
        controller.start(display);

        verify(display, times(1)).display("WELCOME TO PUBLIC LIBRARY\n");
    }

    @Test
    public void shouldStartTheNewApplication() {
        Console console = mock(Console.class);
        Controller controller = new Controller();

        when(console.getUserInput()).thenReturn("2");

        exit.expectSystemExitWithStatus(0);
        controller.start(console);

        verify(controller).start(console);

    }
}