package tests.letscode.concurrency.tasks.step.C;

public class PrintService {

    private static final int NUM_TASKS = 10;

    public static void main(String[] args) {
        executeRunnable();
    }

    /*
    Executing threads using Runnable.
     */
    private static void executeRunnable() {
        for (int i = 1; i <= NUM_TASKS; i++) {
            final Thread thread = new Thread(new PrintTask(i));
            thread.start();
        }
    }
}
