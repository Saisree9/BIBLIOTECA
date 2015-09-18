package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LogOutOptionTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldStartTheNewApplication() {
        Console console = mock(Console.class);
        LogOutOption logOutOption = new LogOutOption(console);
        Controller controller = mock(Controller.class);

        when(console.getUserInput()).thenReturn("2");

        exit.expectSystemExitWithStatus(0);
        logOutOption.doOperation();

        verify(controller).start(console);

    }
}