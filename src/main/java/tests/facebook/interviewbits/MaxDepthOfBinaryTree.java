package tests.facebook.interviewbits;

import tests.leetcode.challenge30days.dataStructure.TreeNode;

public class MaxDepthOfBinaryTree {
    public static int maxDepth(TreeNode A) {
        return depth(A, 0);
    }

    private static int depth(TreeNode a, int i) {
        if (a == null) return i;
        return Math.max(depth(a.left, i+1), depth(a.right, i+1));
    }
}
