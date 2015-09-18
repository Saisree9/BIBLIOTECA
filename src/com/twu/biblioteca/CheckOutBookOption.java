package com.twu.biblioteca;

//checkout's book from the library
public class CheckOutBookOption implements MainMenuOption {
    private static final int UNKNOWN_YEAR = 0;
    private Library library;
    private Console console;
    private User user;

    public CheckOutBookOption(Library library, Console console,User user) {
        this.library = library;
        this.console = console;
        this.user = user;
    }

    @Override
    public void doOperation() {
        console.display("Enter booktitle to checkout: ");
        String booktitle = console.getUserInput();
        Book book = new Book(booktitle, "UNKNOWN_AUTHOR", UNKNOWN_YEAR);
        String returnMessage = library.checkOutBook(book,user);
        console.display(returnMessage);

    }
}
