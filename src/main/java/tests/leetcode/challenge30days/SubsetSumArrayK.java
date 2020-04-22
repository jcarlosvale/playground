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
        LinkedList<Integer> sums = new LinkedList<>();
        int sum = 0;
        //accumulative sum by index mapping
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == k) {
                count++;
            }
            LinkedList<Integer> tempSums = new LinkedList<>();
            Set<Integer> sumSet = new HashSet<>();

            for (int j:sums) {
                sum = nums[i] + j;
                if (sum == k){
                    count++;
                }
                if(!sumSet.contains(sum)) {
                    tempSums.add(sum);
                    sumSet.add(sum);
                }
            }
            if (sums.isEmpty()) {
                tempSums.addFirst(nums[i]);
                sumSet.add(nums[i]);
            } else {
                if(!sumSet.contains(nums[i])) {
                    tempSums.addFirst(nums[i]);
                    sumSet.add(nums[i]);
                }
            }
            sums = tempSums;
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
//        System.out.println(subarraySum(new int[]{1,2,3,4,5},15));//1
//        System.out.println(subarraySum(new int[]{1,1,1},2));//2
//        System.out.println(subarraySum(new int[]{1,0,1},1));//4
//        System.out.println(subarraySum(new int[]{-1,-1,1},0));//4
        System.out.println(subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0},0)); //55


    }
}
