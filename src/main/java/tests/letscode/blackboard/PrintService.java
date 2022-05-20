package tests.letscode.blackboard;

public class PrintService {

    private static final int NUM_TASKS = 10;

    public static void main(String[] args) {
        System.out.println("INICIO MAIN");

        Runnable task1 = () -> {
            try {
                System.out.println("Executando task 1...");
                Thread.sleep(500);
                System.out.println("Executou task 1...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try {
                System.out.println("Executando task 2...");
                Thread.sleep(100);
                System.out.println("Executou task 2...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task3 = () -> {
            try {
                System.out.println("Executando task 3...");
                Thread.sleep(200);
                System.out.println("Executou task 3...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();

        System.out.println("FIM MAIN");


//        for (int i = 1; i <= NUM_TASKS; i++) {
//            final Thread thread = new Thread(() -> System.out.println("Joao"));
//            thread.start();
//        }
    }
}