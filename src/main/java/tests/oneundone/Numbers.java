package tests.oneundone;

/*

// Implement a program that prints the numbers 1 .. 100 in ascending order
// Use two threads, one thread printing even numbers, the other printing odd numbers only
 */
public class Numbers {

    private static final int MAX = 100;
    private static int ODD = 1;
    private static int EVEN = 2;

    public synchronized void printEven() throws InterruptedException {
        while(EVEN <= 100) {
            wait();
            System.out.println(EVEN);
            EVEN += 2;
            notifyAll();
        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while(ODD <= 100) {
            System.out.println(ODD);
            ODD += 2;
            notifyAll();
            wait();
        }
    }


    public static void main(String[] args) {

        Numbers number = new Numbers();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    number.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    number.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }



}
