package tests.amazon;

import java.util.Arrays;

public class Solution {
    public static int solution(int[] A) {
        Long minDiff = null;
        if (A.length > 1) {
            Arrays.sort(A);
            int[] sortedArray = A;
            long pivot = sortedArray[0];
            for (int index = 1; index < sortedArray.length; index++) {
                long element = sortedArray[index];
                if (element == pivot){
                    return 0;
                } else {
                    long diff = element - pivot;
                    if (null == minDiff) {
                        minDiff = diff;
                    } else {
                        minDiff = (diff < minDiff) ? diff : minDiff;
                    }
                    pivot = element;
                }
            }
        }
        if (null == minDiff) return -2;
        if (minDiff > 100_000_000) return -1;
        return (int) Math.abs(minDiff);
    }

    public static void main(String[] args) {
        //testar array 1 elemento
       // System.out.println(solution(new int[] {1}));
        // todos iguais
       // System.out.println(solution(new int[] {1, 1}));
        // exemplo
        System.out.println(solution(new int[] {-2147483647, 2147483647}));
        // exemplo
        //System.out.println(solution(new int[] {0, 3 ,3 ,7 , 5, 3, 11, 1}));
    }
}
