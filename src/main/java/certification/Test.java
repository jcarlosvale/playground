package certification;

import java.util.ArrayList;
import java.util.Arrays;
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
         System.out.println(taskOfPairing(List.of(0L, 8844194L, 2953613L)));
     }
}
