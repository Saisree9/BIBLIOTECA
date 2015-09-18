package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvalidMenuOptionTest {
    @Test
    public void shouldDisplaySelectAValidOptionMessage() {
        Console console = mock(Console.class);
        MainMenuOption invalidMenuOption = new InvalidMenuOption(console);
        invalidMenuOption.doOperation();
        verify(console).display("Select a valid option\n");

    }
}
