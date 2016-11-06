/**
 * Created by Devjiu on 06.11.2016.
 */
public class Student extends Person{
    private boolean sleepy;

    public boolean isSleepy() {
        return sleepy;
    }

    public void setSleepy(boolean sleepy) {
        this.sleepy = sleepy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sleepy=" + sleepy +
                '}';
    }
}
