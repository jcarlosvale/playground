package certification.concurrency;

public class MultiplasThreads {

    public static void main(String[] args) {
        Runnable imprimirCatalogo = () -> System.out.println("Imprimindo catalogo");
        Runnable imprimirRegistros = () -> {
            for (int i = 0; i < 4; i++)
                System.out.println("Imprimindo registro: " + i);
        };

        System.out.println("inicio");
        new Thread(imprimirCatalogo).start();
        new Thread(imprimirRegistros).start();
        new Thread(imprimirCatalogo).start();
        System.out.println("fim");
    }
}
