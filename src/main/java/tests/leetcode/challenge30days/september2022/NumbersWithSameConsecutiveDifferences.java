package tests.leetcode.challenge30days.september2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 *
 * 967. Numbers With Same Consecutive Differences
 *
 *
 * Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.
 *
 * Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * Example 2:
 *
 * Input: n = 2, k = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *
 *
 * Constraints:
 *
 * 2 <= n <= 9
 * 0 <= k <= 9
 */
public class NumbersWithSameConsecutiveDifferences {

    public static int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> numbers = new HashSet<>();


        //trivial
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        //2->n
        for (int i = 2; i <= n; i++) {
            Set<Integer> temp = new HashSet<>();
            for(int number : numbers) {
                int lastDigit = number%10;
                //somando
                if (lastDigit + k <= 9) {
                    temp.add(number * 10 + (lastDigit + k));
                }
                if (lastDigit - k >= 0) {
                    temp.add(number * 10 + (lastDigit-k));
                }
            }
            numbers = temp;
        }

        int [] arrayToReturn = new int[numbers.size()];
        int i = 0;

        for(int number : numbers) {
            arrayToReturn[i] = number;
            i++;
        }

        return arrayToReturn;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numsSameConsecDiff(3,7))); //[181,292,707,818,929]
    //    System.out.println(Arrays.toString(numsSameConsecDiff(2,1))); //[32, 65, 34, 98, 67, 10, 43, 12, 76, 45, 78, 21, 54, 23, 87, 56, 89]

    //    int[] arr = {101,121,123,210,212,232,234,321,323,343,345,432,434,454,456,543,545,565,567,654,656,676,678,765,767,787,789,876,878,898,987,
        //    989};
     //   System.out.println(arr.length);
    }
}
