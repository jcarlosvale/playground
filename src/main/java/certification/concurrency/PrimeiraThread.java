package certification.concurrency;

public class PrimeiraThread {

    public static void main(String[] args) {
        new Thread(() -> System.out.print(" Ola ")).start();
        System.out.print(" Mundo ");
    }
}
