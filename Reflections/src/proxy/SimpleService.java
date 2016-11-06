package proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Devjiu on 28.10.2016.
 */
public class SimpleService implements Service {
    private final Map<String, Integer> cache = new HashMap<>();

    @Override
    public int doHardWork(String name) {
        if(cache.containsKey(name)) return cache.get(name);

        doSleep();
        return name.hashCode();
    }

    private void doSleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
