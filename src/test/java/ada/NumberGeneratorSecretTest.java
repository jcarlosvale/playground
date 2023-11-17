package ada;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NumberGeneratorSecretTest {

    @Test
    public void testaEvenThread() throws InterruptedException {
        Object lock = new Object();
        List<Integer> resultList = new ArrayList<>();
        EvenThread evenThread = new EvenThread(lock, resultList, 10);

        evenThread.start();  // Usar start() para iniciar uma nova thread

        // Aguardar um curto período para garantir que a thread teve tempo de gerar alguns números
        Thread.sleep(100);

        evenThread.interrupt();  // Interromper a thread para garantir que ela termine

        // Verificar se a lista gerada contém apenas números pares
        for (Integer number : resultList) {
            assertTrue(number % 2 == 0);
        }
    }

    @Test
    public void testaOddThread() throws InterruptedException {
        Object lock = new Object();
        List<Integer> resultList = new ArrayList<>();
        OddThread oddThread = new OddThread(lock, resultList, 10);

        oddThread.start();  // Usar start() para iniciar uma nova thread

        // Aguardar um curto período para garantir que a thread teve tempo de gerar alguns números
        Thread.sleep(100);

        oddThread.interrupt();  // Interromper a thread para garantir que ela termine

        // Verificar se a lista gerada contém apenas números ímpares
        for (Integer number : resultList) {
            assertTrue(number % 2 == 1);
        }
    }

    @Test
    public void testaThreadsUsadas() {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> resultList = generator.generateNumbers();

        // Verificar se a thread par está no estado TERMINATED (indicando que ela foi executada)
        assertEquals(Thread.State.TERMINATED, generator.oddThread.getState());
        assertEquals(Thread.State.TERMINATED, generator.evenThread.getState());
    }


}