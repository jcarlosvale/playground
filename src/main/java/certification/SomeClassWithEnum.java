package certification;

public class SomeClassWithEnum {
    enum SomeEnum {
        VALUE1, VALUE2
    }

    public static void main(String[] args) {
        SomeEnum VALUE1 = null;
        String b = new String("HELLO");
        method(b);
        System.out.println(b);
    }

    private static void method(String b) {
        b += " WORLD";
    }
}
