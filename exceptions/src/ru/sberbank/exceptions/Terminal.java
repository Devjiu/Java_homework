package ru.sberbank.exceptions;

/**
 * Created by Devjiu on 06.11.2016.
 */
public interface Terminal {
    void checkStatus ( );
    void putMoney    (Integer sum);
    void getMoney    (Integer sum);

    void logIn       (Integer pass);
    void logOut      ( );
}
