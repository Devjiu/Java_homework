package ru.sberbank.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static ru.sberbank.utils.CollectionUtils.*;

/**
 * Created by Devjiu on 21.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        CountMap<Integer> map2 = new CountMapImpl<>();

        map2.add(10);
        map2.add(10);
        //int count = map.getCount(5); // 2
        //int count = map.getCount(6); // 1
        int count = map.getCount(10); // 3
        System.out.println(map.remove(10));
        System.out.println(map.toMap().toString());
        System.out.println(map.size());
        map.addAll(map2);
        System.out.println(map.toMap().toString());
        System.out.println(map2.toMap().toString());
        Map<Object,Object> m = map2.toMap();
        map.toMap(m);
        System.out.println(m.toString());

        System.out.println("===============================================================");

        List<Integer> src = new ArrayList<Integer>();
        src.add(1);
        src.add(12);
        src.add(14);
        src.add(1717);

        List<Number> dst = new ArrayList<>();
        addAll(src, dst);
        System.out.println(dst);
        System.out.println( indexOf(dst, 1));
        System.out.println( indexOf(src, 1) );
        List ex = limit(src,3);
        removeAll(dst,ex);
        System.out.println( "Number dst: " + dst + "\n"+
                "Integer src: " + src +  "\n"+
                "dst, dst: " + containsAll(dst, dst) + "\n"+
                "ALL dst, src: " + containsAll(dst, src) + "\n" +
                "ANY dst, src: " + containsAny(src, src) + "\n" +
                "src, ex: " + containsAll(src, ex) + "\n"
                + "src, dst doesn't work");
        addAll(src, dst);
        System.out.println( dst );
        System.out.println(range(src,1,14));
        System.out.println(range(dst, 1, 3, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return 0;
            }
        }));


    }
}
