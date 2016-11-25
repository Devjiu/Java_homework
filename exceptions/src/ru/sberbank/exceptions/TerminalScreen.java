package ru.sberbank.exceptions;

import java.util.Scanner;

/**
 * Created by Devjiu on 25.11.2016.
 */
public class TerminalScreen {
    private final Scanner scanner;

    public TerminalScreen() {
        this.scanner = new Scanner(System.in);
    }
    public void print (String string){
        System.out.println(string);
    }
    public String nextCommand(){
        return scanner.nextLine();
    }
}
