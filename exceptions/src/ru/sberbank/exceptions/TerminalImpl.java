package ru.sberbank.exceptions;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Devjiu on 06.11.2016.
 */
public class TerminalImpl implements Terminal{

    private final TerminalServer    server;
    private final PasswordValidator pinValidator;
    private final TerminalScreen    screen;

    private          Integer id;
    private          int     logCount;
    private volatile boolean isLoginAccessible;

    private          Timer      timer;
    private          TimerTask  timerTask;
    private volatile long       delayStart;
    private final    long       delay       =  20000;


    public TerminalImpl() {

        this.server       = new TerminalServerImpl();
        this.pinValidator = new PinValidator();
        this.screen       = new TerminalScreen();

        this.isLoginAccessible = true;
        this.logCount          = 0;

        this.timer     = new Timer();
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                isLoginAccessible = false;
                try {
                    delayStart = System.currentTimeMillis();
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    isLoginAccessible = true;
                }
            }
        };
    }

    @Override
    public void checkStatus() {
        Integer info = null;
        try {
            info = server.showStatus(id);
        } catch (LoginException e) {
            screen.print(e.getMessage());
            return;
        }
        screen.print("You have " + info.toString());
    }

    @Override
    public void putMoney(Integer sum) {
        try {
            server.addMoney(id, sum);
        } catch (LoginException e) {
            screen.print(e.getMessage());
            return;
        } catch (IllegalAmountOfMoneyException e){
            screen.print(e.getMessage());
            return;
        }
        screen.print("Operation is successful");
    }

    @Override
    public void getMoney(Integer sum) {
        try {
            if(sum%100 != 0){
                throw new NoMoneyInTerminalExeption();
            }
            server.getMoney(id, sum);
        } catch (LoginException e) {
            screen.print(e.getMessage());
            return;
        } catch (NoMoneyInTerminalExeption e) {
            screen.print(e.getMessage());
        } catch (NotEnoughMoneyExeption e) {
            screen.print(e.getMessage());
        }
        screen.print("Operation is successful");
    }

    @Override
    public void logIn(Integer pass) {
        try {
            if(!isLoginAccessible){
                long currentDelay = delay - System.currentTimeMillis() + delayStart;
                throw new TerminalIsLockedException(currentDelay/1000);
            }
            id = pinValidator.checkPass(pass);
            screen.print("You are successfully logged in");
        } catch (TerminalIsLockedException e) {
            screen.print(e.getMessage());
        } catch (InvalidPasswordExeption e) {
            screen.print(e.getMessage());
            logCount++;
            if (logCount > 2){
                this.timer.schedule(timerTask, 0);
                logCount = 0;
            }
        }
    }

    @Override
    public void logOut() {
        id = null;
        screen.print("You are successfully logged out");
    }

    private void run (){
        String commandArr = screen.nextCommand();
        String args[] = commandArr.split(" ");
        switch (args[0]) {
            case "log":
                logIn( new Integer(args[1]));
                break;
            case "exit":
                logOut();
                break;
            case "check":
                checkStatus();
                break;
            case "add":
                putMoney(new Integer(args[1]));
                break;
            case "get":
                getMoney(new Integer(args[1]));
                break;
            default: screen.print("Wrong command");
        }
    }

    public static void main(String[] args) {
        TerminalImpl terminal = new TerminalImpl();
        while (true){
            terminal.run();
        }
    }
}
