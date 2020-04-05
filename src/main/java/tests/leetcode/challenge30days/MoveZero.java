package tests.leetcode.challenge30days;

import java.util.Arrays;

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
