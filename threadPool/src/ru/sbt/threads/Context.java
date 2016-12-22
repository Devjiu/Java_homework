package ru.sbt.threads;

/**
 * Created by Devjiu on 13.12.2016.
 */
public interface Context {

    /**Возвращает количество тасков,
     * которые на текущий момент успешно выполнились.
     * @return
     */
    int getCompletedTaskCount();

    /**Возвращает количество тасков,
     * при исполнении которых произошел Exception.
     * @return
     */
    int getFailedTaskCount();

    /**Возвращает количество методов,
     *  которые не выполнились из-за следующего метода.
     * @return
     */
    int getInterruptedTaskCount();

    /**Отменяет выполнения тасков,
     * которые еще не начали выполняться.
     */
    void interrupt();

    /**Вернет True
     * если все таски были выполнены или отменены.
     * False в проотивном случае.
     * @return
     */
    boolean isFinished();

}
