package tests.facebook;

public class RotaryLocker {

    public static long getMinCodeEntryTime(int N, int M, int[] C) {
        long count = 0L;
        //step 0
        count += Math.min(C[0]-1, N+1 - C[0]);
        //other steps
        for (int i = 1; i < M; i++) {
            if (C[i] > C[i-1]) {
                count += Math.min(C[i]-C[i-1], N+C[i-1] - C[i]);
            } else {
                count += Math.min(C[i-1]-C[i], N+C[i] - C[i-1]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getMinCodeEntryTime(3, 3, new int[]{1,2,3}));//2
        System.out.println(getMinCodeEntryTime(10, 4, new int[]{9,4,4,8}));//11
    }

}
