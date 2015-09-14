package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class MainMenuTest {
    @Test
    public void shouldDoListBooksOperationWhenListBooksOptionIsSelected() {
        MainMenuOption listBooksOption = mock(ListBooksOption.class);
        MainMenu mainMenu = new MainMenu(listBooksOption);

        mainMenu.doOperation();

        verify(listBooksOption).doOperation();
    }

    @Test
    public void shouldDoInvalidMenuOperationWhenInvalidOptionIsSelected() {
        MainMenuOption invalidMenuOption = mock(InvalidMenuOption.class);
        MainMenu mainMenu = new MainMenu(invalidMenuOption);

        mainMenu.doOperation();

        verify(invalidMenuOption).doOperation();
    }

    @Test
    public void shouldDoQuitOperationWhenQuitOptionIsSelected() {
        MainMenuOption quit = mock(Quit.class);
        MainMenu mainMenu = new MainMenu(quit);

        mainMenu.doOperation();

        verify(quit).doOperation();
    }

    @Test
    public void shouldDoCheckOutOperationWhenCheckOutOptionIsSelected() {
        MainMenuOption checkOutOption = mock(CheckOutOption.class);
        MainMenu mainMenu = new MainMenu(checkOutOption);

        mainMenu.doOperation();

        verify(checkOutOption).doOperation();
    }

    @Test
    public void shouldDoReturnOperationWhenReturnOptionIsSelected() {
        MainMenuOption returnOption = mock(ReturnOption.class);
        MainMenu mainMenu = new MainMenu(returnOption);

        mainMenu.doOperation();

        verify(returnOption).doOperation();
    }

    @Test
    public void shouldEqualToItself() {
        MainMenuOption quitOption = new Quit();
        MainMenu mainMenu = new MainMenu(quitOption);

        assertEquals(mainMenu, mainMenu);
    }

    @Test
    public void shouldEqualToMainMenuHavingSameMainMenuOption() {
        MainMenuOption quitOption = new Quit();
        MainMenu mainMenu1 = new MainMenu(quitOption);
        MainMenu mainMenu2 = new MainMenu(quitOption);


        assertEquals(mainMenu1, mainMenu2);
    }

}