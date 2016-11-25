package ru.sberbank.exceptions;


/**
 * Created by Devjiu on 06.11.2016.
 */
public interface TerminalServer {
    void    getMoney    (Integer id, Integer sum) throws LoginException, NotEnoughMoneyExeption, NoMoneyInTerminalExeption;
    void    addMoney    (Integer id, Integer sum) throws LoginException, IllegalAmountOfMoneyException;
    Integer showStatus  (Integer id)              throws LoginException;
}
