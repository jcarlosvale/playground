package monitoria;

import java.util.Scanner;

public class Monitoria_13_04_23 {

    public static void main(String[] args) {
        double [] vetor = lerVetor();
        int quantidade = contarNumerosVetor(vetor);
        double soma = somar(vetor);

        System.out.println(quantidade);
        System.out.println(soma);
        System.out.println(soma / quantidade);
    }

    static double somar(double[] vetor) {
        double soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == -1) {
                break;
            } else {
                soma += vetor[i];
            }
        }
        return soma;
    }

    static int contarNumerosVetor(double [] vetor) {
        int contador = 0;
        for(double item : vetor){
            if (item != -1) {
                contador++;
            } else {
                break;
            }
        }
        return contador;
    }

    static double [] lerVetor() {
        System.out.println("Leitura do Vetor");
        double [] vetor = new double[100];
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor " + (i+1) + ":");
            double numero = scan.nextDouble();
            vetor[i] = numero;
            if (numero == -1) {
                break;
            }
        }
        return vetor;
    }






    private static void enganarPuloDeLinha() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Numerico: ");
        int num = scan.nextInt();
        scan.nextLine(); //ler o pulo de linha
        System.out.println("Texto: ");
        String string = scan.nextLine();

        System.out.println(num);
        System.out.println(string);
    }


}
