package certification;


class Parent {
    void method(){}
}

abstract class AbstractSon extends Parent {

    @Override
    abstract void method();
}

public class KitchenSink {
    private int numForks;

    public static void main(String[] args) {
        var x = Long.parseLong("100");
        var y = Long.valueOf("100");
        System.out.print("""
                "# forks = " + numForks +
                " # knives = " + numKnives +
                # cups = 0""");
    }
}