package certification;

public class StaticTest {
    public static class SomeStaticClass {
        public void hello() {
            System.out.println("hello");
        }
    }

}

class ExternalClass {
    public static final void someStaticMethod() {}
    public static void main(String[] args) {
        StaticTest.SomeStaticClass someStaticClass = new StaticTest.SomeStaticClass();
        someStaticClass.hello();
    }
}
