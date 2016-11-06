package ru.sberbank.bean_utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Devjiu on 05.11.2016.
 */
public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     **/
    public static void assign(Object to, Object from) {
        List<Storage> setterFields = new ArrayList<>();
        Pattern setPattern = Pattern.compile("(set)([a-zA-Z0-9]*)");
        search( setPattern, setterFields, to.getClass().getDeclaredMethods(), Boolean.TRUE );

        List<Storage> getterFields = new ArrayList<>();
        Pattern getPattern = Pattern.compile("(get|is)([a-zA-Z0-9]*)");
        search( getPattern, getterFields, from.getClass().getDeclaredMethods(), Boolean.FALSE );

        for (int i = 0; i < setterFields.size(); i++){
            Storage current = setterFields.get(i);
            for (Storage s: getterFields) {
                if ( (current.name.equals(s.name)) && (current.types.equals(s.types)) ){
                    try {
                        current.method.setAccessible(true);
                        current.method.invoke(to, s.method.invoke(from));
                        System.out.println(current.method + " ======== " + s.name);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    private static void search(Pattern pattern, List list, Method[] methods, Boolean setter ) {
        int i = 0;
        for (Method m: methods ) {
            Matcher matcher = pattern.matcher(m.getName());
            if(matcher.matches()) {
                Storage storage = new Storage();
                storage.name = matcher.group(2);
                storage.method = m;
                if(setter) {
                    storage.types = m.getParameterTypes()[0];
                }else {
                    storage.types = m.getReturnType();
                }
                list.add( storage );
                m.getParameterTypes();
                System.out.println( storage.name + " " + storage.method + " " + storage.types + " " );
            }
        }
    }

    private static class Storage{
        public Method method;
        public Class types;
        public String name;
    }

}
