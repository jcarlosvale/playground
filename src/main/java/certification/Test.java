package certification;

import java.util.ArrayList;
import java.util.List;

class Test {

    public static long taskOfPairing(List<Long> freq) {
        List<Long> zeros = new ArrayList<>();

        long acc = 0;
        //division by 2
        for(Long elem : freq) {
            acc += elem / 2;
            zeros.add(elem % 2);
        }
        //get neighbors
        for(int i = 0; i< zeros.size()-1; i++) {
            long sum = (zeros.get(i) + zeros.get(i+1)) / 2;
            if (sum == 1) {
                acc++;
                zeros.set(i+1,0L);
            }
        }
        return acc;
    }

     public static void main(String[] args) {
         String prefixo = "BE_JV_006_";

         for (int i = 1; i <= 40; i++) {
             String numeroFormatado = String.format("%02d", i); // Formata o número para ter dois dígitos
             String nomeArquivo = prefixo + numeroFormatado + ".json";
             System.out.println(nomeArquivo);
         }
     }
}
