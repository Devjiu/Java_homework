package sandbox;

/**
 * Created by Devjiu on 15.12.2016.
 */
public class ThrowExceptionSimpleCase implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
