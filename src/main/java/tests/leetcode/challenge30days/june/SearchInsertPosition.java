package tests.leetcode.challenge30days.june;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3356/
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where
 * it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);
        if (pos < 0) pos = -pos -1;
        return pos;
    }
}
