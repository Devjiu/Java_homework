package ru.sberbank.utils;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Devjiu on 20.10.2016.
 */
public class CountMapImpl<T> implements CountMap<T>{
    private final Map<T,Integer> map;

    public CountMapImpl() {
        this.map = new TreeMap<T, Integer>();
    }

    @Override
    public void add(T o) {
        if (map.containsKey(o)){
            map.replace( o , map.get(o) + 1 );
        } else {
          map.put( o , 1 );
        }
    }

    @Override
    public int getCount(T o) {
        if (map.containsKey(o)){

            return map.get(o);

        }else{

            return 0;
        }
    }

    @Override
    public int remove(T o) {
        int before = getCount(o);
        map.remove(o);
        return before;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        for (Object e: source.toMap().keySet()) {
            if (map.containsKey((T) e)){
                map.replace( (T) e , (int)source.toMap().get( (T) e) + (int)map.get((T)e));
            }else{
                map.put((T) e, (int)source.toMap().get( (T) e));
            }
        }
    }

    @Override
    public Map<? super T,? super Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<? super T,? super Integer> destination) {
        destination.putAll(  (Map) this.toMap() );
    }
}
