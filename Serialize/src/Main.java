import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Devjiu on 29.11.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Alex",11);
        try(ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream("person.serialized"))){
                s.writeObject(person);
        }
    }
}

