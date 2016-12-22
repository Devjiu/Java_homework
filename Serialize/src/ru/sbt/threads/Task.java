package ru.sbt.threads;

/**
 * Created by Devjiu on 22.12.2016.
 */
public class Task extends Thread {
    private boolean isInterrupted;

    public Task(Runnable target) {
        super(target);
        this.isInterrupted = false;
    }

    @Override
    public synchronized void start() {
        if(!isInterrupted){
            super.start();
        }
    }

    @Override
    public boolean isInterrupted() {
        if (isInterrupted){
            return true;
        }else{
            return super.isInterrupted();
        }
    }

    @Override
    public void interrupt() {
        super.interrupt();
        isInterrupted = true;
    }
}
