package tests.leetcode.challenge30days.march2021;

/*
Given an integer array nums, return the length of the longest wiggle sequence.

A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive
and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two
elements is trivially a wiggle sequence.

For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) are alternately positive
and negative.
In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences, the first because its first two differences
are positive and the second because its last difference is zero.
A subsequence is obtained by deleting some elements (eventually, also zero) from the original sequence, leaving the
remaining elements in their original order.

Example 1:

Input: nums = [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
Example 2:

Input: nums = [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
Example 3:

Input: nums = [1,2,3,4,5,6,7,8,9]
Output: 2


Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 1000


Follow up: Could you solve this in O(n) time?
 */
public class Wiggle_Subsequence {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int counter = 1;
        int candidate = nums[0];
        boolean mustBePositive = true;
        //find first difference
        int initial = nums.length;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - candidate;
            if (diff > 0) {
                mustBePositive = false;
                initial = i;
                counter++;
                break;
            }
            if (diff < 0) {
                mustBePositive = true;
                initial = i;
                counter++;
                break;
            }
        }
        //
        for (int i = initial; i < nums.length; i++) {
            int diff = nums[i] - candidate;
            if (mustBePositive) {
                if (diff > 0) {
                    candidate = nums[i];
                    counter++;
                    mustBePositive = false;
                } else {
                    candidate = Math.min(candidate, nums[i]);
                }
            } else {
                if (diff < 0) {
                    candidate = nums[i];
                    counter++;
                    mustBePositive = true;
                } else {
                    candidate = Math.max(candidate, nums[i]);
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[] {1,7,4,9,2,5})); //6
        System.out.println(wiggleMaxLength(new int[] {1,17,5,10,13,15,10,5,16,8})); //7
        System.out.println(wiggleMaxLength(new int[] {1,2,3,4,5,6,7,8,9})); //2
    }
}
