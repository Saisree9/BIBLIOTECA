package com.twu.biblioteca;

public class CheckOutOption implements MainMenuOption {
    private static final int UNKNOWN_YEAR = 0;
    private Library library;
    private Console console;

    public CheckOutOption(Library library, Console console) {
        this.library = library;
        this.console = console;
    }

    @Override
    public void doOperation() {
        console.display("Enter booktitle to checkout: ");
        String booktitle = console.getUserInput();
        Book book = new Book(booktitle, "UNKNOWN_AUTHOR", UNKNOWN_YEAR);
        String returnMessage = library.checkOutBook(book);
        console.display(returnMessage);

    }
}
