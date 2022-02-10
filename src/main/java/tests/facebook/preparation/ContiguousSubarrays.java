package tests.facebook.preparation;

import java.util.Arrays;

public class ContiguousSubarrays {
    static int[] countSubarrays(int[] arr) {
        int [] ans = new int[arr.length];
        int[] rightAns = countRightSide(arr);
        int[] leftAns = countLeftSide(arr);

        //merge
        for (int i = 0; i < arr.length; i++) {
            ans[i] = rightAns[i] + leftAns[i] - 1;
        }
        return ans;
    }

    private static int[] countLeftSide(int[] arr) {
        int [] ans = new int[arr.length];
        //left
        for (int i = arr.length-1; i >= 0; i--) {
            int curr = arr[i];
            ans[i]++;
            int pos = i+1;
            while(pos < arr.length) {
                if (curr > arr[pos]) {
                    ans[i] += ans[pos];
                }
                pos += ans[pos];
            }
        }
        return ans;
    }

    private static int[] countRightSide(int[] arr) {
        int [] ans = new int[arr.length];
        //right
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            ans[i]++;
            int pos = i-1;
            while(pos >= 0) {
                if (curr > arr[pos]) {
                    ans[i] += ans[pos];
                }
                pos -= ans[pos];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countSubarrays(new int[]{3,4,1,6,2}))); //{1,3,1,5,1}
    }
}
