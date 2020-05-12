package tests.leetcode.challenge30days;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
 * element which appears exactly once. Find this single element that appears only once.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int indexNumber = findUniqueNumber(nums, 0, nums.length-1);
        return nums[indexNumber];
    }

    private static int findUniqueNumber(int[] nums, int start, int end) {
        if (start > end) return -1;
        int middle = start + (end-start) / 2;
        int middleNumber = nums[middle];
        int previousNumber = (middle - 1 < 0) ? middleNumber-1 : nums[middle-1];
        int nextNumber = (middle + 1 >= nums.length) ? middleNumber-1 : nums[middle + 1];
        if ((middleNumber == previousNumber) || (middleNumber == nextNumber)) {
            int candidate1 = findUniqueNumber(nums, start, middle - 1);
            int candidate2 = findUniqueNumber(nums, middle + 1, end);
            return Math.max(candidate1, candidate2);
        } else {
            return middle;
        }
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int [] {1,1,2,3,3,4,4,8,8})); //2
        System.out.println(singleNonDuplicate(new int [] {3,3,7,7,10,11,11}));  //10
    }
}
