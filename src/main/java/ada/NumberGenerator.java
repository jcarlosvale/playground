package ada;

import java.util.ArrayList;
import java.util.List;

class EvenThread extends Thread {
    private final Object lock;
    private final List<Integer> resultList;
    private final int maxNumber;

    public EvenThread(Object lock, List<Integer> resultList, int maxNumber) {
        this.lock = lock;
        this.resultList = resultList;
        this.maxNumber = maxNumber;
    }

    @Override
    public void run() {
        for (int i = 2; i <= maxNumber; i += 2) {
            synchronized (lock) {
                resultList.add(i);
                lock.notify();  // Notificar a outra thread para continuar
                try {
                    if (i < maxNumber) {
                        lock.wait();  // Aguardar pela outra thread
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class OddThread extends Thread {
    private final Object lock;
    private final List<Integer> resultList;
    private final int maxNumber;

    public OddThread(Object lock, List<Integer> resultList, int maxNumber) {
        this.lock = lock;
        this.resultList = resultList;
        this.maxNumber = maxNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i <= maxNumber; i += 2) {
            synchronized (lock) {
                resultList.add(i);
                lock.notify();  // Notificar a outra thread para continuar
                try {
                    if (i < maxNumber - 1) {
                        lock.wait();  // Aguardar pela outra thread
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class NumberGenerator {
    private static final int MAX_NUMBER = 100;
    private static final Object lock = new Object();

    public EvenThread evenThread;
    public OddThread oddThread;

    public List<Integer> resultList;

    public NumberGenerator() {
        resultList = new ArrayList<>();
        evenThread = new EvenThread(lock, resultList, MAX_NUMBER);
        oddThread = new OddThread(lock, resultList, MAX_NUMBER);
    }

    public List<Integer> generateNumbers() {
        // Iniciar as threads
        oddThread.start();
        evenThread.start();

        try {
            // Aguardar até que ambas as threads terminem
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> resultList = generator.generateNumbers();

        // Imprimir a lista
        for (Integer number : resultList) {
            System.out.print(number + " ");
        }
    }
}