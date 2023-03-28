package monitoria;

import java.util.Scanner;

//LOGICA DE PROGRAMACAO
    /*
    LINGUAGEM ESTRUTURADA:
    - TIPADO
        * VARIAVEL
        ** PRIMITIVAS:
            *** INTEIROS: BYTE (1 BYTE) SHORT (2 BYTES) INT (4 BYTES) LONG (8 BYTES)
            **** LITERAL: INT

            *** REAIS: FLOAT (4 BYTES)  DOUBLE (8 BYTES)
            **** LITERAL: DOUBLE

            *** BOOLEANOS: BOOLEAN

            *** CARACTERES: CHAR (*2 BYTES)


    - SINTAXE
        -- break

    - INSTRUCOES

    - LACOS CONDICIONAIS
        -- IF / ELSE
        -- SWITCH/CASE

    - LACOS DE REPETICAO


    ==> celsius em fahrenheit
    ==> mês
     */
public class HelloJava {

    //ASSINATURA: retorno + nome + parametros
    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);

//        System.out.println(12.5);
//        System.out.println(12);


        System.out.println("Digite um numero que representa um mes: ");

        int mes = scanner.nextInt();


        switch (mes) {
            case 1:
                System.out.println("JAN");
                break;
            case 2:
                System.out.println("FEV");
                break;
            case 3:
                System.out.println("MAR");
                break;
            default:
                System.out.println("MES INVALIDO");
        }







//        if (mes == 1) {
//            System.out.println("JANEIRO");
//        } else {
//            if (mes == 2) {
//                System.out.println("FEVEREIRO");
//            }  else {
//                if (mes == 3) {
//                    System.out.println("MARÇO");
//                }
//                else {
//                    System.out.println("MES INVALIDO");
//                }
//            }
//        }






    }

}
