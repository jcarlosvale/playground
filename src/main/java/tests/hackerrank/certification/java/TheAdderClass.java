package tests.hackerrank.certification.java;

abstract class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

class Adder extends Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
public class TheAdderClass {

    public static void main(String[] args) {
        Float f1 = new Float("3.0");
        int x = f1.intValue();
        byte b = f1.byteValue();
        double d = f1.doubleValue();
        System.out.println(x + b+ d);
    }
}
