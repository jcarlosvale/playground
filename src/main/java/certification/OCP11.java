package certification;

import java.util.ArrayList;
import java.util.List;

class SomeClass {
    void print (List<Object> o) {}
}

public class OCP11 extends SomeClass{


    void print (ArrayList<Object> l) {}

    public static void main(String[] args) {
        usingVar();
        short i = 1;
        short j = 2;
        short w = 2 + 1;
        System.out.println(w);
    }

    private static void usingVar() {
        int [] x = {1,2,3};
        for(var i : x)
            System.out.println(i);
    }

}
