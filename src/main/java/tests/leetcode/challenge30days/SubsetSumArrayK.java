package tests.leetcode.challenge30days;

import java.util.*;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum
 * equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 */
public class SubsetSumArrayK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] previousSums= new int[nums.length];
        int sum;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == k) {
                count++;
            }
            int[] currentSums = new int[nums.length];
            currentSums[0] = nums[i];
            for (int j = 1; j <= i; j++) {
                sum = nums[i] + previousSums[j-1];
                currentSums[j] = sum;
                if (sum == k){
                    count++;
                }
            }
            previousSums = currentSums;
        }
        return count;
    }
/*
    private static void insertMap(Map<Integer, Integer> sumFrequency, int sum) {
        if (sumFrequency.containsKey(sum)) {
            sumFrequency.put(sum, sumFrequency.get(sum) + 1);
        } else {
            sumFrequency.put(sum, 1);
        }
    }
 */

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3,4,5},15));//1
        System.out.println(subarraySum(new int[]{1,1,1},2));//2
        System.out.println(subarraySum(new int[]{1,0,1},1));//4
        System.out.println(subarraySum(new int[]{-1,-1,1},0));//1
        System.out.println(subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0},0)); //55


    }
}
