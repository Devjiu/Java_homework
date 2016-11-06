/**
 * Created by Devjiu on 05.11.2016.
 */
public class Person {
    private int One;
    private boolean Bool;

    public int getOne() {
        return One;
    }

    public void setOne(int one) {
        One = one;
    }

    public boolean isBool() {
        return Bool;
    }

    public void setBool(boolean bool) {
        Bool = bool;
    }

    public int Eat(){
        return 4;
    };

    @Override
    public String toString() {
        return "Person{" +
                "One=" + One +
                ", Bool=" + Bool +
                '}';
    }
}
