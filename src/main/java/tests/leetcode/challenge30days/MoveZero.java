package tests.leetcode.challenge30days;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 * non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZero {
    public static void moveZeroes(int[] nums) {
        int countZero=0;
        int element = 0;
        for(int i = 0; i< nums.length; i++){
            element = nums[i];
            if (element == 0) {
                countZero++;
            } else {
                if (countZero == 0) continue;
                nums[i-countZero] = element;
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int [] nums = {1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
