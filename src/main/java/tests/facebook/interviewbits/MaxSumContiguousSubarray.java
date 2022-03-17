package tests.facebook.interviewbits;

import java.util.List;

public class MaxSumContiguousSubarray {
    public static int maxSubArray(final List<Integer> A) {
        int ans = A.get(0);
        int acc = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (acc + A.get(i) > A.get(i)) {
                acc += A.get(i);
            } else {
                acc = A.get(i);
            }
            ans = Math.max(ans, acc);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(List.of(1, 2, 3, 4, -10))); //10
        System.out.println(maxSubArray(List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4))); //6
    }
}
