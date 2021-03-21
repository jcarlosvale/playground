package tests.leetcode.challenge30days.march2021;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3679/
Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.



Example 1:

Input: 1
Output: true
Example 2:

Input: 10
Output: false
Example 3:

Input: 16
Output: true
Example 4:

Input: 24
Output: false
Example 5:

Input: 46
Output: true


Note:

1 <= N <= 10^9
 */
public class Reordered_Power_of_2 {
    public boolean reorderedPowerOf2(int N) {
        char[] res1 = String.valueOf(N).toCharArray();
        Arrays.sort(res1);
        for (int i = 0; i < 30; i++) {
            char[] res2 = String.valueOf(1 << i).toCharArray();
            Arrays.sort(res2);
            if (Arrays.equals(res1, res2)) return true;
        }
        return false;
    }
}
