package sandbox;

import java.util.Date;

/**
 * Created by Devjiu on 15.12.2016.
 */
public class Main {

    public static void main(String[] args) {
        Thread t = new Thread(new ThrowExceptionSimpleCase());

        t.setUncaughtExceptionHandler(((t1, e) -> System.out.printf("Exception %s has been caught from thred %s.\n",
                e, t1.getName())));

        t.start();
        Date d = new Date();
        Man man = new Man("Andrey", d);
        System.out.println(man);
        d.setTime(0);
        //man.getDate().setTime(0);
        System.out.println(man);

    }
}
