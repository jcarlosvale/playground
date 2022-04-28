package tests.letscode.concurrency.tasks.step.A;

public class PrintService {

    private static final int NUM_TASKS = 10;

    public static void main(String[] args) {
        for (int i = 1; i <= NUM_TASKS; i++) {
            var task = new PrintTask(i);
            task.print();
        }
    }
}
