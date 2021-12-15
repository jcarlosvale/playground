package tests.amazon;

import java.util.ArrayList;
import java.util.List;

public class BookPages {

    public static long numberOfWays(String book) {
        List<Long> countList = new ArrayList<>();

        //counting
        int i = 0;
        long count;
        while(i < book.length()) {
            char charCurr = book.charAt(i);
            count = 0;

            while(charCurr == book.charAt(i)) {
                count++;
                i++;
                if (i >= book.length()) break;
            }
            countList.add(count);
        }

        //memoization
        long[][][] memoized = new long[countList.size()][countList.size()][countList.size()];
        for (i = 0; i < countList.size(); i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= j; k++) {
                    if(i==j && j==k) {
                        memoized[i][j][k] = countList.get(i);
                    } else {
                         if (i != j && j != k) {
                             memoized[i][j][k] = countList.get(i) * countList.get(i) * countList.get(k);
                         }
                    }
                }
            }
        }

        //count solutions
        long countSolution = 0;
        for (i = 0; i < countList.size(); i++) {
            for (int j = i+1; j < countList.size(); j++) {
                for (int k = j+1; k < countList.size(); k++) {
                    if (i != j && j != k) {
                        long p1 = countList.get(i);
                        long p2 = countList.get(i + 1);
                        long p3 = countList.get(i + 2);
                        countSolution += p1 * p2 * p3;
                    }
                }
            }
        }

        return countSolution;
    }


    public static void main(String[] args) {
        System.out.println(numberOfWays("10111")); //3
        System.out.println(numberOfWays("0101010")); //35
        System.out.println(numberOfWays("01011010")); //8?!
    }

}
