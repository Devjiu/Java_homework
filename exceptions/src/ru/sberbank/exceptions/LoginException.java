package ru.sberbank.exceptions;

/**
 * Created by Devjiu on 25.11.2016.
 */
public class LoginException extends Exception{
    @Override
    public String getMessage() {
        return "You are not logged in. Please, log in";
    }
}
