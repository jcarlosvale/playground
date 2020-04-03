package certification;

import java.util.ArrayList;
import java.util.List;

class SomeClass {
    void print (List<Object> o) {}
}

public class OCP11 extends SomeClass{


    void print (ArrayList<Object> l) {}

    public static void main(String[] args) {
//        usingVar();
//        short i = 1;
//        short j = 2;
//        short w = 2 + 1;
//        System.out.println(w);
        OCP11 ocp11 = new OCP11();
        ocp11.methodException(false);
    }

    public void someMethdd() {
        return;
    }

    private static void usingVar() {
        int [] x = {1,2,3};
        for(var i : x)
            System.out.println(i);
    }

    public boolean methodException(boolean exception) {
        try{
            System.out.println("TRY");
            throw new RuntimeException("MyException");
        } catch (Exception e) {
            System.out.println("EXCEPTION");
            if (exception) {
                throw new RuntimeException("MyException 2");
            } else {
                return true;
            }
        } finally {
            System.out.println("FINALLY");
        }
    }

}
