package tests.facebook;

public class RotaryLockerV2 {

    public static long getMinCodeEntryTime(int N, int M, int[] C) {
        long count = 0L;
        int locker1 = 1;
        int locker2 = 1;

        for (int i = 0; i < M; i++) {
            //locker 1
            int min1 = 0;
            if (C[i] > locker1) {
                min1 = Math.min(C[i]-locker1, N+locker1 - C[i]);
            } else {
                min1 = Math.min(locker1-C[i], N+C[i] - locker1);
            }
            //locker 2
            int min2 = 0;
            if (C[i] > locker2) {
                min2 = Math.min(C[i]-locker2, N+locker2 - C[i]);
            } else {
                min2 = Math.min(locker2-C[i], N+C[i] - locker2);
            }
            if (min1 <= min2) {
                locker1 = C[i];
                count+=min1;
            } else {
                locker2 = C[i];
                count+=min2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getMinCodeEntryTime(3, 3, new int[]{1,2,3}));//2
        System.out.println(getMinCodeEntryTime(10, 4, new int[]{9,4,4,8}));//6
    }

}
