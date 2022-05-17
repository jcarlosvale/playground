package certification.concurrency;

public class ThreadDaemonComPause {

    public static void pause() {
        try {
            Thread.sleep(2_000); // pausar por 2 segundos
        } catch (InterruptedException e) {}
        System.out.println("Thread finalizada");
    }

    public static void main(String[] unused) {
        var tarefa = new Thread(() -> pause()); // Cria thread
        tarefa.setDaemon(true); //Thread daemon
        tarefa.start(); // Inicia thread
        System.out.println("Fim do programa!");
    }
}
