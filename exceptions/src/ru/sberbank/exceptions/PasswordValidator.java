package ru.sberbank.exceptions;

/**
 * Created by Devjiu on 25.11.2016.
 */
public interface PasswordValidator {
    Integer checkPass (Integer pass) throws InvalidPasswordExeption;
}
