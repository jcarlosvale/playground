package certification.concurrency;

public class EnviarMensagemComSleep {

    private static boolean mensagemEnviada = false;

    public static void main(String[] a) {

        new Thread(() -> {
            try {
                Thread.sleep(2000); //2 segundos
                mensagemEnviada = true;
            } catch (InterruptedException e) {
                System.out.println("thread Interrompida!");
            }
        }).start();

        while (!mensagemEnviada) {
            System.out.println("Enviando mensagem...");
            try {
                Thread.sleep(500); // 500 milissegundos
            } catch (InterruptedException e) {
                System.out.println("main interrompido!");
            }
        }
        System.out.println("Mensagem enviada!!");
    }
}
