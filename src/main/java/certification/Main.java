package certification;

import java.util.function.Supplier;

class Employee{     int age;    }

public class Main {
    public static void main(String[] args) {

        System.out.println(args.length);
        var hasParams = (args == null ? false : true);
        System.out.println(hasParams);

        Employee e = new Employee();
        Supplier<Employee> se = ()->{ e.age = 40; return e; }; //1
        e.age = 50;//2
        System.out.println(se.get().age); //3

        String s = "       ";
        System.out.println(s.isEmpty());
        System.out.println(s.isBlank());
        System.out.println(s.strip() != "");

    }
}
