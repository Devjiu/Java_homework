package proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by Devjiu on 28.10.2016.
 */
public class CacheInvocationHandler implements InvocationHandler {
    private final Map<List<Object>,Object> cache = new HashMap();
    private final Object delegate;

    public CacheInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> key = key(method, args);
        if (cache.containsKey(key)) return cache.get(key);

        Object res = calc(method, args);
        cache.put(key,res);
        return res;
    }

    public static <T> T cache(T delegate){
        return (T)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(), new CacheInvocationHandler(delegate));
    }

    private Object calc(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        return method.invoke(delegate,args);
    }


    private List<Object> key(Method method, Object[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(method);
        objects.addAll(asList(args));
        return objects;
    }
}
