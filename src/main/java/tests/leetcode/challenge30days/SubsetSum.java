package tests.leetcode.challenge30days;

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
