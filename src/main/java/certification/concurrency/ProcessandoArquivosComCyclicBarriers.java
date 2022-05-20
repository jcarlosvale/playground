package certification.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class ProcessandoArquivosComCyclicBarriers {

    private void lerArquivo() { System.out.println("Lendo arquivo"); }
    private void processarArquivo() { System.out.println("Processando arquivo"); }
    private void salvarArquivo() { System.out.println("Salvar arquivo"); }
    public void realizarTarefa(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            lerArquivo();
            c1.await();
            processarArquivo();
            c2.await();
            salvarArquivo();
        } catch (BrokenBarrierException | InterruptedException e) {
            //tratamento de excecao
        }
    }
    public static void main(String[] args) {
        var service = Executors.newFixedThreadPool(4);
        try {
            var manager = new ProcessandoArquivosComCyclicBarriers();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4);
            for (int i = 0; i < 4; i++)
                service.submit(() -> manager.realizarTarefa(c1, c2));
        } finally {
            service.shutdown();
        }
    }
}
