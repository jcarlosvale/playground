package certification.concurrency;

import java.util.concurrent.Executors;

public class ProcessandoArquivos {

    private void lerArquivo() { System.out.println("Lendo arquivo"); }
    private void processarArquivo() { System.out.println("Processando arquivo"); }
    private void salvarArquivo() { System.out.println("Salvar arquivo"); }
    public void realizarTarefa() {
        lerArquivo();
        processarArquivo();
        salvarArquivo();
    }
    public static void main(String[] args) {
        var service = Executors.newFixedThreadPool(4);
        try {
            var manager = new ProcessandoArquivos();
            for (int i = 0; i < 4; i++)
                service.submit(() -> manager.realizarTarefa());
        } finally {
            service.shutdown();
        }
    }
}
