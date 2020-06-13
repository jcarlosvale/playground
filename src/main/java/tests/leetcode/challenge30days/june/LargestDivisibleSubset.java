package tests.leetcode.challenge30days.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in
 * this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 */
public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {

        if (nums.length == 0) return new ArrayList<>();

        // sort the array
        Arrays.sort(nums);

        // array that maintains the maximum index
        // till which the condition is satisfied
        int divCount[] = new int[nums.length];

        // we will always have atleast one
        // element divisible by itself
        Arrays.fill(divCount, 1);

        // maintain the index of the last increment
        int prev[] = new int[nums.length];
        Arrays.fill(prev, -1);

        // index at which last increment happened
        int max_ind = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                // only increment the maximum index if
                // this iteration will increase it
                if (nums[i] % nums[j] == 0 &&
                        divCount[i] < divCount[j] + 1) {
                    prev[i] = j;
                    divCount[i] = divCount[j] + 1;

                }

            }
            // Update last index of largest subset if size
            // of current subset is more.
            if (divCount[i] > divCount[max_ind])
                max_ind = i;
        }

        List<Integer> solution = new ArrayList<>();
        // Print result
        int k = max_ind;
        while (k >= 0) {
            solution.add(nums[k]);
            k = prev[k];
        }

        return solution;
    }

    public static void main(String[] args) {
    }
}
