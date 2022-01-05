package tests.facebook;

import java.util.Arrays;

class Hops {

    public static long getSecondsRequired(long N, int F, long[] P) {
        long count = 0;
        long[] newP = Arrays.copyOf(P, F+1);
        newP[F] = N;
        Arrays.sort(newP);
        //make the fogs Approximations
        for(int i = 1; i < newP.length; i++) {
            count += newP[i] - newP[i-1] - 1;
        }
        //remainder fogs
        count += F;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getSecondsRequired(3, 1, new long[]{1})); //2
        System.out.println(getSecondsRequired(6, 3, new long[]{5,2,4})); //4
    }

}