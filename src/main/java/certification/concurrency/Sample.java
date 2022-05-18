package certification.concurrency;

import java.util.concurrent.*;

public class Sample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var service = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> somar = service.submit(() -> 14 + 27);
            System.out.println(somar.get()); // 41
        } finally {
            service.shutdown();
        }
    }
}
