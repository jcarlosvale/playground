package tests.letscode.concurrency.tasks.step.E;

import tests.letscode.concurrency.tasks.step.C.PrintTaskLambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintServiceModern {

    private static final int NUM_TASKS = 10;

    public static void main(String[] args) {
        final ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            for (int i = 1; i <= NUM_TASKS; i++) {
                final PrintTaskLambda printTaskLambda = new PrintTaskLambda(i);
                service.execute(() -> printTaskLambda.print());
            }
        } finally {
            service.shutdown();
        }
    }
}
