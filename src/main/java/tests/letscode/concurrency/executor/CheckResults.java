package tests.letscode.concurrency.executor;

import java.util.concurrent.*;

public class CheckResults {
    private static int counter = 0;
    
    public static void main(String[] unused) throws Exception {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 500; i++) {
                    CheckResults.counter++;
                }
            });
            result.get(10, TimeUnit.SECONDS);
            System.out.println("Executado!");
        } catch (TimeoutException e) {
            System.out.println("Nao executou no tempo esperado.");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
        System.out.println("FIM MAIN");
    } 
}
