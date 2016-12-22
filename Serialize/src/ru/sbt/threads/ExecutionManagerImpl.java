package ru.sbt.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devjiu on 15.12.2016.
 */
public class ExecutionManagerImpl implements ExecutionManager {

    private List<Task> numOfThreads;

    public ExecutionManagerImpl() {
        this.numOfThreads = new ArrayList<>();
    }

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {

        for (Runnable task : tasks) {
            Task thread = new Task(task);
            numOfThreads.add(thread);
        }

        for (Task thread : numOfThreads) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
        }

        for (Task myThread : numOfThreads) {
            try {
                myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        callback.run();

        return new ContextImpl(numOfThreads);
    }
}
