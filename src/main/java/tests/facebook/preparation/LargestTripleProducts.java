package tests.facebook.preparation;

public class LargestTripleProducts {

    static int[] findMaxProduct(int[] arr) {
        // Write your code here
        int [] ans = new int[arr.length];
        int [] higher = new int[3];

        for (int i = 0; i < arr.length; i++) {
            insert(higher, arr[i]);
            if (i <=1) {
                ans[i] = -1;
            } else {
                ans[i] = higher[0] * higher[1] * higher[2];
            }
        }

        return ans;
    }

    private static void insert(int[] higher, int n) {
        if(n >= higher[0]) {
            higher[2] = higher[1];
            higher[1] = higher[0];
            higher[0] = n;
            return;
        }
        if(n >= higher[1]) {
            higher[2] = higher[1];
            higher[1] = n;
            return;
        }
        if(n > higher[2]) {
            higher[2] = n;
        }
    }
}
