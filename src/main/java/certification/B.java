package certification;

@FunctionalInterface
interface SomeA {
    int sume(int a, int b);
}

class A {
     int a = 1;
     void print() {
         System.out.println(a);
     }
} 
public class B extends A {
     int a = 2;
     public static void main(String[] args) {
         B b = new B();
         b.print();
         int a = 10;
         b.someMethod(a);
     }

    private void someMethod(int a) {
         final int x = 10;
        SomeA some = (a1, b) -> x + a;
    }
} 
