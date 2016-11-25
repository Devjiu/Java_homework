package ru.sberbank.exceptions;

/**
 * Created by Devjiu on 25.11.2016.
 */
public class NoMoneyInTerminalExeption extends Exception {
    @Override
    public String getMessage() {
        return "Please, enter the sum, which is divided by 100.";
    }
}
