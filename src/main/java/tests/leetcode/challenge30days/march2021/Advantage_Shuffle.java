package tests.leetcode.challenge30days.march2021;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3683/
Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for
which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.



Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]
Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]


Note:

1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9

https://dev.to/seanpgallivan/solution-advantage-shuffle-p39
 */
public class Advantage_Shuffle {
    public static int[] advantageCount(int[] A, int[] B) {
        Integer[] ord = new Integer[B.length];
        int[] ans = new int[A.length];
        for (int i = 0; i < B.length; i++) ord[i] = i;
        Arrays.sort(ord, (a,b) -> Integer.compare(B[b], B[a]));
        Arrays.sort(A);
        int i = 0, j = B.length - 1;
        for (int ix : ord)
            ans[ix] = A[j] > B[ix] ? A[j--] : A[i++];
        return ans;
    }
}
