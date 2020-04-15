package tests.leetcode.challenge30days;

import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[] {0,1}));
        System.out.println(findMaxLength(new int[] {0,1,1,0,1,1,1,0}));
    }

}
