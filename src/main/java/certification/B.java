package certification;

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
     }
} 
