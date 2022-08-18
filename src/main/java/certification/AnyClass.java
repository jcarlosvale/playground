package certification;

public class AnyClass {

    public int somar(int x, int y) {
        return x + y;
    }

    private int subtrair(int x, int y) {
        return x - y;
    }

    protected double multiplicar(int x, int y) {
        return x * y;
    }

    double dividir(int x, int y) {
        return x / y;
    }

    public static void main(String[] args) {
        AnyClass anyClass = new AnyClass();
        anyClass.somar(1, 2);
        anyClass.subtrair(1,2);
        anyClass.multiplicar(1,2);

    }
}
