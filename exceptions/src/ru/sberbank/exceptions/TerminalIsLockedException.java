package ru.sberbank.exceptions;

/**
 * Created by Devjiu on 25.11.2016.
 */
public class TerminalIsLockedException extends Exception{
    private long delay;
    public TerminalIsLockedException(long delay) {
        super();
        this.delay = delay;
    }

    @Override
    public String getMessage() {
        return "Terminal is blocked for " + delay + " seconds.";
    }
}
