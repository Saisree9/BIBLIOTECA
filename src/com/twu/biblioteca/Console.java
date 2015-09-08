package com.twu.biblioteca;

import java.util.Scanner;

//Console the message
public class Console {

    public void display(String message) {
        System.out.print(message);
    }

    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
