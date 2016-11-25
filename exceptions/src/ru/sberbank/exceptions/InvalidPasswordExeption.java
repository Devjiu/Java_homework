package ru.sberbank.exceptions;

/**
 * Created by Devjiu on 25.11.2016.
 */
public class InvalidPasswordExeption extends Exception {
    @Override
    public String getMessage() {
        return "Wrong password.";
    }
}
