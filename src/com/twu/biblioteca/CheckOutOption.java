package com.twu.biblioteca;

public class CheckOutOption implements MainMenuOption {

    private static final int UNKNOWN_YEAR = 0;

    @Override
    public void doOperation(Library library, Console console) {
        console.display("Enter booktitle to checkout: ");
        String booktitle=console.getUserInput();
        Book book=new Book(booktitle,"UNKNOWN_AUTHOR",UNKNOWN_YEAR);
        String returnMessage=library.checkOut(book);
        console.display(returnMessage);

    }
}
