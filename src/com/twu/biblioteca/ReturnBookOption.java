package com.twu.biblioteca;

public class ReturnBookOption implements MainMenuOption {
    private static final int UNKNOWN_YEAR = 0;
    private Console console;
    private Library library;
    private User user;


    public ReturnBookOption(Library library, Console console,User user) {
        this.console = console;
        this.library = library;
        this.user = user;
    }

    @Override
    public void doOperation() {
        console.display("Enter return book title: ");
        String booktitle = console.getUserInput();
        Book book = new Book(booktitle, "UNKNOWN_AUTHOR", UNKNOWN_YEAR);
        String returnMessage = library.returnBook(book,user);
        console.display(returnMessage);
    }
}
