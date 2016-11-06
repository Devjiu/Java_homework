import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devjiu on 28.10.2016.
 */
public class ReflectionUtils {
    public  static  void printMethods(Object o){
        Class<?> clazz = o.getClass();
        while(clazz != null) {
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method);
            }
        }
        clazz = clazz.getSuperclass();
        System.out.println("--------------------------");
    }

    public static<T> List<T> getFields(Object o, Class<T> clazz){
        List<T> res = new ArrayList<>();

        Class<?> clazzz = o.getClass();
        while(clazzz!=null) {
            for (Field f : clazzz.getDeclaredFields()) {
                if (f.getType() == clazz)
                    f.setAccessible(true);
                try{
                    T value = (T) f.get(o);
                    res.add(value);
                }catch (IllegalAccessException e) {
                   throw new RuntimeException(e);
                } ;
            }

            clazzz = clazzz.getSuperclass();
        }
        return  res;
    };
}
