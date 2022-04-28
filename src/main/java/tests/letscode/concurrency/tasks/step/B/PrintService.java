package tests.letscode.concurrency.tasks.step.B;

public class PrintService {

    private static final int NUM_TASKS = 10;

    public static void main(String[] args) {
        for (int i = 1; i <= NUM_TASKS; i++) {
            final Thread thread = new Thread(new PrintTask(i));
            thread.start();
        }
    }
}
