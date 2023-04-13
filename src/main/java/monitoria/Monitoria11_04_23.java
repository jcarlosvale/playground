package monitoria;

import java.util.Scanner;

public class Monitoria11_04_23 {

    public static void main(String[] args) {

        escreverNaTela("dfghjdoijdsaoi");
        escreverNaTela("Estudem Java, eh facil");





        //par();
//        var scanner = new Scanner(System.in);

//        double dizima = 0.13;
//        BigDecimal bigDecimal =
//                BigDecimal
//                        .valueOf(dizima)
//                        .setScale(2, RoundingMode.HALF_UP);
//
//        bigDecimal =
//                bigDecimal
//                        .add(BigDecimal.ONE)
//                        .multiply(BigDecimal.valueOf(0.555))
//                        .subtract(BigDecimal.TEN);
//
//        System.out.println("bigdecimal: " + bigDecimal);


//        String texto = "algum texto";
//        texto = texto.toUpperCase();
//        System.out.println(texto);







//        System.out.println("double: " + dizima);
//        System.out.println("bigdecimal: " + bigDizima);

//        BigDecimal salario = BigDecimal.valueOf(scanner.nextDouble());
//        System.out.println(salario);
//        System.out.println(1.3 * salario);



//        double salario = scanner.nextDouble();
//        System.out.println(salario);
//        System.out.println(1.3 * salario);
//        System.out.println(Math.ceil(1.3*salario));
//        System.out.println(Math.floor(1.3*salario));
    }

    static void escreverNaTela(String texto) {
        System.out.println(texto.toUpperCase());
    }

    static int somar(int x, int y) {
        return x + y;
    }


    static boolean ehPar(int numero){
        return (numero % 2 == 0);
    }



















    private static void par() {
        var scanner = new Scanner(System.in);
        int numero = scanner.nextInt();


        if (numero % 2 == 0) {
            System.out.println("Par");
        } else {
            System.out.println("Impar");
        }

        String resultado = (numero % 2 == 0) ? "Par" : "Impar";

        System.out.println(resultado);
    }
}
