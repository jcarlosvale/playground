package certification.concurrency;

public class EnviarMensagemComInterrupt {

    private static boolean mensagemEnviada = false;

    public static void main(String[] a) {

        final var mainThread = Thread.currentThread();

        new Thread(() -> {
            try {
                Thread.sleep(2000); //2 segundos
                mensagemEnviada = true;
                mainThread.interrupt();
            } catch (InterruptedException e) {
                System.out.println("thread Interrompida!");
            }
        }).start();

        while (!mensagemEnviada) {
            System.out.println("Enviando mensagem...");
            try {
                Thread.sleep(5000); // 5 segundos
            } catch (InterruptedException e) {
                System.out.println("main interrompido!");
            }
        }
        System.out.println("Mensagem enviada!!");
    }
}
