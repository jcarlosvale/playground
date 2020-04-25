package tests.leetcode.challenge30days;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        //matrix of adjacency
        boolean [] [] adjacencyMatrix = new boolean[nums.length][nums.length];
        //building
        for (int i = 0; i < nums.length; i++) {
            int limit = i+nums[i];
            if (limit >= nums.length) limit = nums.length-1;
            for (int j = i; j <= limit ; j++) {
                adjacencyMatrix[i][j] = true;
            }
        }
        //Roy-Warshall
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length ; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (adjacencyMatrix[i][j]) {
                        if (adjacencyMatrix[i][k] || adjacencyMatrix[j][k]) {
                            adjacencyMatrix[i][k] = true;
                        }
                    }
                }
            }
        }
        return adjacencyMatrix[0][nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4})); //true
        System.out.println(canJump(new int[]{3,2,1,0,4})); //false
        System.out.println(canJump(new int[]{0})); //true
        System.out.println(canJump(new int[]{1,1,1,0})); //true

    }
}
