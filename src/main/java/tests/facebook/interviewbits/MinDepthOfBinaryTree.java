package tests.facebook.interviewbits;

import tests.leetcode.challenge30days.dataStructure.TreeNode;

public class MinDepthOfBinaryTree {
    public static int minDeph(TreeNode A) {
        return depth(A, 1);
    }

    private static int depth(TreeNode a, int i) {
        if ((a.left == null) && (a.right == null)) return i;
        else {
            int leftDepth = Integer.MAX_VALUE;
            int rightDepth = Integer.MAX_VALUE;
            if (a.right != null) {
                rightDepth = depth(a.right, i + 1);
            }
            if (a.left != null) {
                leftDepth = depth(a.left, i + 1);
            }
            return Math.min(rightDepth, leftDepth);
        }
    }

    public static void main(String[] args) {
        System.out.println(minDeph(
                new TreeNode(1)
        )); //1

        System.out.println(minDeph(
                new TreeNode(1,
                        new TreeNode(2, null, new TreeNode(3)),
                        null
        ))); //3

        System.out.println(minDeph(
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3)
                ))); //2
    }
}
