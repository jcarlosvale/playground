package tests.leetcode.challenge30days;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
 * sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class SubsetSum {

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int tmpMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            tmpMax = Math.max(nums[i], tmpMax+nums[i]);
            maxSum = Math.max(maxSum, tmpMax);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int [] {-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(maxSubArray(new int [] {-2,1}));
//        System.out.println(maxSubArray(new int [] {1,-2}));
    }
}
