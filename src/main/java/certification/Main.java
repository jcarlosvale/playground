package certification;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        SomeClassWithEnum.SomeEnum x = SomeClassWithEnum.SomeEnum.VALUE1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0,0);
        list.add(2,0);

        System.out.println(list);

        Predicate<Integer> predicate = (var) -> var > 0;
    }
}
