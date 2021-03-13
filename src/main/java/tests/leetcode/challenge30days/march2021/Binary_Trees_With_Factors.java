package tests.leetcode.challenge30days.march2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3670/
Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 10^9 + 7.



Example 1:

Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:

Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].


Constraints:

1 <= arr.length <= 1000
2 <= arr[i] <= 109
 */
public class Binary_Trees_With_Factors {
    public static int numFactoredBinaryTrees(int[] arr) {
        final long MOD = (long) 1e9 + 7;
        Arrays.sort(arr);
        long [] dp = new long[arr.length];
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexes.put(arr[i], i);
        }
        Arrays.fill(dp, -1);

        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = (res + dfs(arr, indexes, dp, i, MOD)) % MOD;
        }

        return (int) res;
    }

    private static long dfs(int[] arr, Map<Integer, Integer> indexes, long[] dp, int idx, long MOD) {
        if(dp[idx] != -1L) {
            return dp[idx];
        }
        long res = 1L;
        for (int i = idx-1; i != -1; i--) {
            if (arr[idx] % arr[i] == 0) {
                int theOther = arr[idx] / arr[i];
                Integer theOtherIndex = indexes.get(theOther);
                if (theOtherIndex != null) {
                    res = (res + dfs(arr, indexes, dp, i, MOD) * dfs(arr, indexes, dp, theOtherIndex, MOD)) % MOD;
                }
            }
        }
        dp[idx] = res;
        return res;
    }
}
