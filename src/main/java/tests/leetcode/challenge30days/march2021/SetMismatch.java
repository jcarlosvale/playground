package tests.leetcode.challenge30days.march2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3658/
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]

Example 2:
Input: nums = [1,1]
Output: [1,2]

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
 */
public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        Set<Integer> set = new HashSet<>();
        int expectedSum = (1 + nums.length) * nums.length/ 2;
        //find duplicate
        for (int i = 0; i < nums.length; i++) {
            expectedSum -= nums[i];
            if (!set.add(nums[i])) {
                duplicate = nums[i];
                expectedSum += duplicate;
            }
        }
        return new int[] {duplicate, expectedSum};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,2,2,4}))); //2, 3
        System.out.println(Arrays.toString(findErrorNums(new int[]{3,2,3,4,6,5}))); //3, 1
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,5,3,2,2,7,6,4,8,9}))); //2, 10


    }
}
