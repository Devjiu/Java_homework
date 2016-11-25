package ru.sberbank.exceptions;

import java.util.HashMap;

/**
 * Created by Devjiu on 25.11.2016.
 */
public class TerminalServerImpl implements TerminalServer {
    private final HashMap<Integer, Integer> clientDB;

    public TerminalServerImpl() {
        this.clientDB = new HashMap<>();
        this.clientDB.put(1, 40000);
        this.clientDB.put(2, 200);
    }

    public void getCache(Integer id, Integer amount)throws NotEnoughMoneyExeption{
        Integer cache = clientDB.get(id);
        Integer result = cache - amount;
        if (result < 0){
            throw new NotEnoughMoneyExeption();
        } else {
            clientDB.replace(id, result);
        }
    }

    @Override
    public void getMoney(Integer id, Integer sum) throws NotEnoughMoneyExeption, NoMoneyInTerminalExeption, LoginException {
        Integer cache = clientDB.get(id);
        Integer result = cache - sum;
        if (result < 0){
            throw new NotEnoughMoneyExeption();
        } else {
            clientDB.replace(id, result);
        }
    }

    public Integer showStatus(Integer id){
        return clientDB.get(id);
    }

    @Override
    public void addMoney(Integer id, Integer sum) throws LoginException, IllegalAmountOfMoneyException {
        Integer cache = clientDB.get(id);
        clientDB.replace(id, cache + sum);
    }

}
