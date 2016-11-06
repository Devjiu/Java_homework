import static ru.sberbank.bean_utils.BeanUtils.*;
/**
 * Created by Devjiu on 28.10.2016.
 */

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setBool(true);
        p1.setOne(1);
        Student p2 = new Student();
        assign(p2, p1);
        System.out.println(p2);

        /*Service service = cache(new SimpleService());
        System.out.println(service.doHardWork("Alex"));
        System.out.println(service.doHardWork("Bob"));
        System.out.println(service.doHardWork("Alex"));*/
    }
}
