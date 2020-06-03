package tests.leetcode.challenge30days;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */
public class ContigousArray {

    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int cont = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) cont --;
            else cont++;
            if (map.containsKey(cont)) {
                maxLength = Math.max(maxLength, i - map.get(cont));
            } else map.put(cont, i);
        }
        return maxLength;
    }

    public static int findMaxLength2(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[] {0,1}));  //2
        System.out.println(findMaxLength(new int[] {0,1,1,0,1,1,1,0})); //4

        System.out.println(findMaxLength2(new int[] {0,1}));  //2
        System.out.println(findMaxLength2(new int[] {0,1,1,0,1,1,1,0})); //4

    }

}
