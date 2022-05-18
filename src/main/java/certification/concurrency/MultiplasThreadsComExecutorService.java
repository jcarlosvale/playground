package certification.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiplasThreadsComExecutorService {

    public static void main(String[] args) {
        Runnable imprimirCatalogo = () -> System.out.println("Imprimindo catalogo");
        Runnable imprimirRegistros = () -> {
            for (int i = 0; i < 4; i++)
                System.out.println("Imprimindo registro: " + i);
        };

        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            System.out.println("inicio");
            service.execute(imprimirCatalogo);
            service.execute(imprimirRegistros);
            service.execute(imprimirCatalogo);
            System.out.println("fim");

        } finally {
            service.shutdown();
        }
    }
}
