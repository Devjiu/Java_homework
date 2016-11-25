package ru.sberbank.exceptions;

/**
 * Created by Devjiu on 25.11.2016.
 */
public class NotEnoughMoneyExeption extends Exception {
    @Override
    public String getMessage() {
        return "Not enough money on your Score.";
    }
}
