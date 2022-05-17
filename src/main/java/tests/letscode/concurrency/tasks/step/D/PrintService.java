package tests.letscode.concurrency.tasks.step.D;

import tests.letscode.concurrency.tasks.step.C.PrintTaskLambda;
import tests.letscode.concurrency.tasks.step.C.PrintTaskThread;

public class PrintService {

    private static final int NUM_TASKS = 10;

    public static void main(String[] args) {
        executeRunnable();
//        executeThreads();
//        executeLambdaExpression();
    }

    /*
    Executing threads using lambda expressions.
     */
    private static void executeLambdaExpression() {
        for (int i = 1; i <= NUM_TASKS; i++) {
            final PrintTaskLambda printTaskLambda = new PrintTaskLambda(i);
            final Thread thread = new Thread(() -> printTaskLambda.print());
            thread.start();
        }
    }

    /*
    Executing threads using only the thread.
    */
    private static void executeThreads() {
        for (int i = 1; i <= NUM_TASKS; i++) {
            final Thread thread = new PrintTaskThread(i);
            thread.start();
        }
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
