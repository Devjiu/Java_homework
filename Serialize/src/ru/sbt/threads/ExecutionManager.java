package ru.sbt.threads;

/**
 * Created by Devjiu on 13.12.2016.
 */
public interface ExecutionManager {

    /** Неблокирующий метод, принимает массив тасков
     *  это задания, которые должны выполняться параллельно.
     *  У нас есть пул потоков. После завершения выполняется callback (ровно 1 раз).
     * @param callback
     * @param tasks
     * @return
     */
     Context execute(Runnable callback, Runnable... tasks);
}
