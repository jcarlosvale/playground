package tests.leetcode.challenge30days;

import java.util.Arrays;

public class ProductArray {

    public static int[] productExceptSelf(int[] nums) {
        int mult = 1;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros ++;
            } else {
                mult *= nums[i];
            }
        }

        if(zeros > 1) {
            for (int i = 0; i < nums.length; i++) nums[i] = 0;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (zeros == 1) {
                    if (nums[i] != 0) nums[i] = 0;
                    else nums[i] = mult;
                } else{
                    nums[i] = mult/nums[i];
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
     //   System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,0})));

    }

}
