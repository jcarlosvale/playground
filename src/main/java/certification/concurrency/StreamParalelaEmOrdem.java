package certification.concurrency;

import java.util.stream.Stream;

public class StreamParalelaEmOrdem {

    private static void lerArquivo(String nomeArquivo) {
        try {
            System.out.println("Lendo arquivo " + nomeArquivo);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        Stream.of("arquivo 1", "arquivo 2", "arquivo 3")
                .parallel()
                .forEachOrdered(s -> lerArquivo(s));
        System.out.println("Tempo total de processamento: " + (System.currentTimeMillis() - inicio) + "ms");
    }
}
