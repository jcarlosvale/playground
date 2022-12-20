package monitoria;

public class MonitoriaVetores {

    public static void main(String[] args) {
        /*
        tipos primitivos: numericos (inteiros, pto flutuante), char, boolean
        inteiros: byte, short, int (padrao), long
        flutuante: float, double (padrao)
         */

       // int i = 10;
        //System.out.println(i);

        float f = (float) 1.0;

        int [] vetor = new int[10];
        double[] vetorD = new double[100];
        boolean[] vetorBoolean = {false, true};

        String s = "dfghjklghjdklxhjk";

        /*
        vetor: indexada [0...N-1]
         */


 //       System.out.println(vetorBoolean[0]);

        vetorBoolean[0] = true;
/*
        System.out.println(vetorBoolean[0]);


        System.out.println(vetorBoolean.length);
        System.out.println(s.length());

        //preencher vetor de inteiros com multiplos de 5, 10, 15, 20

        //for(inst 1; inst 2; inst 3)

        for (int indice = 0; indice < vetor.length; indice++) {
            vetor[indice] = (indice+1) * 5;
        }
*/
        //impressao
//        for (int indice = 0; indice < vetor.length; indice++) {
//            System.out.println("Valor posicao " + indice + " : " + vetor[indice]);
//        }

//        int indice = 0;
//        while(indice < vetor.length) {
//            System.out.println("Valor posicao " + indice + " : " + vetor[indice]);
//            indice++;
//        }

//        int indice = 0;
//        do {
//            System.out.println("Valor posicao " + indice + " : " + vetor[indice]);
//            indice++;
//        } while(indice < vetor.length);

        //for-avançado
        //for-each
//        for(int elemento : vetor) {
//
//            if (elemento % 2 == 0) System.out.println(elemento);
//
//        }


        //MATRIZES
        String [] palavras = new String[5];
        palavras[0] = "java";
        palavras[1] = "python";



        String [] [] palavrasCruzadas = new String[4][];

        palavrasCruzadas[0] = new String[2];
        palavrasCruzadas[1] = new String[1];
        palavrasCruzadas[2] = new String[2];
        palavrasCruzadas[3] = new String[1];

        String [] [] outraMatriz = new String[3][4];
        /*
        outraMatriz[0] --> 4 elementos
        outraMatriz[1] --> 4 elementos
        outraMatriz[2] --> 4 elementos
        */

        String[] nomes = {"jose", "joao", "maria", "pedro", "paulo", "java"};

        //insert
        int index = 0;
        for (int i = 0; i < palavrasCruzadas.length; i++) {
            for (int j = 0; j < palavrasCruzadas[i].length; j++) {
                palavrasCruzadas[i][j] = nomes[index];
                index++;
            }
        }

        //imprimir
        for(String [] array :palavrasCruzadas) {
            for(String palavra : array) {
                System.out.println("Palavra: " + palavra);
            }
        }
    }

}
