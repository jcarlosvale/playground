package tests.leetcode.challenge30days;

import java.util.Arrays;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        int size = stones.length;
        if (size == 1) return stones[0];
        if (size == 2) return Math.abs(stones[0] - stones[1]);
        int dif = 0;
        while (size > 2) {
            Arrays.sort(stones);
            dif = stones[stones.length-1] - stones[stones.length - 2];
            stones[stones.length - 1] = dif;
            stones[stones.length - 2] = -1;
            size --;
        }
        Arrays.sort(stones);
        return stones[stones.length-1] - stones[stones.length - 2];
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
