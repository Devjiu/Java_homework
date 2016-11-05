package ru.sberbank.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Devjiu on 05.11.2016.
 */
public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static <T> List<T> limit(List<T> source, int size) {
        List<T> dest = new ArrayList<>();
        for(int i = 0; i < size; i++){
            dest.add( source.get(i) );
        }
        return dest;
    }

    public static <T> void add(List<? super T> source, Object o) {
        source.add( (T) o );
    }

    public static <T> void removeAll(List<? extends T> removeFrom, List<? super T> c2) {
        for (Object o: c2) {
            for(int i =0; i< removeFrom.size(); i++){
                if (o.equals( removeFrom.get(i) ) ){
                    removeFrom.remove(i);
                }
            }
        }

    }
    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<T> c1, List<? extends T> c2) {
        for (T o:c2) {
            if(!c1.contains(o)){
                return false;
            }
        }
        return true;
    }
    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T o:c2) {
            if(c1.contains(o)){
                return true;
            }
        }
        return false;
    }
    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable> List range(List<T> list, Object min, Object max) {
        List<T> des = newArrayList();
        for (T o: list) {
            if ((o.compareTo( min ) >= 0) && (o.compareTo( max ) <= 0 )){
                des.add(o);
            }
        }
        return des;
    }
    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T> List range(List<T> list, Object min, Object max, Comparator<? super T> comparator) {
        List<T> des = newArrayList();
        for (T o: list) {
            if ((comparator.compare(o, (T)min) >= 0) && comparator.compare(o, (T)max) <= 0 ){
                des.add(o);
            }
        }
        return des;
    }
}
