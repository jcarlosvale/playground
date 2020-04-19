package tests.leetcode.challenge30days;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * */

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private static int search(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums[start] == target) return start;
        if (nums[mid] == target) return mid;
        if (nums[end] == target) return end;
        //normal case S-M-E
        if (nums[start] <= nums[mid] && nums[mid] <= nums[end]) {
            if (target > nums[mid]) {
                return search(nums, target, mid+1, end);
            } else {
                return search(nums, target, start, mid-1);
            }
        }
        //middle case  E-S-M
        if (nums[start] >= nums[mid] && nums[mid] <= nums[end]) {
            if (target > nums[start]) {
                return search(nums, target, start, mid-1);
            }
            if (target < nums[mid]) {
                return search(nums, target, start, mid-1);
            }
            return search(nums, target, mid+1, end);
        }
        //right case  M-E-S
        if (nums[start] <= nums[mid] && nums[mid] >= nums[end]) {
            if (target > nums[mid]) {
                return search(nums, target, mid+1, end);
            }
            if (target < nums[start]) {
                return search(nums, target, mid+1, end);
            }
            return search(nums, target, start, mid-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));  //4
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));  //-1
        System.out.println(search(new int[]{1}, 0));  //-1
        System.out.println(search(new int[]{4,5,6,7,8,1,2,3}, 8));  //4
        System.out.println(search(new int[]{5,1,2,3,4}, 1));  //1

    }
}

