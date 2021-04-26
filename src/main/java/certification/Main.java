package certification;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int x = 0;
        System.out.println(inc(++x));
        System.out.println("x = " + x);
        double d = 2.0;
        float f = 1.0f;
        long l = 23l;
        System.out.println(d);
        System.out.println(f);
        System.out.println(l);

        System.out.println(new String("teste").length());
    }

    private static int inc(int i) {
        return i;
    }
}
