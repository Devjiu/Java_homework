package sandbox;

import java.util.Date;

/**
 * Created by Devjiu on 15.12.2016.
 */
public class Man {
    private final String name;
    private final Date date;
    private final Date badDate;


    public Man(String name, Date date){
        this.name = name;
        this.badDate = date;
        this.date = new Date(date.getTime());
        System.out.println("Name: " + this.name + "\n" + "Date: " + this.date);
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return new Date(this.date.getTime());
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", badDate=" + badDate +
                '}';
    }
}
