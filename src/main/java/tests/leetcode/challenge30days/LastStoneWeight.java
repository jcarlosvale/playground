package tests.leetcode.challenge30days;

import java.util.Arrays;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y
 * with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */
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
