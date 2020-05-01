package tests.leetcode.challenge30days;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
 * the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */

import com.sun.source.tree.Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class TreeMaxPathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxPathSum(TreeNode root) {
        // pos 0 = max sum;
        int [] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxPathSum(root, maxSum);
        return maxSum[0];
    }

    private static Integer maxPathSum(TreeNode root, int[] maxSum) {
        if (null == root) return null;

        int [] maxSumLeft  = new int[1];
        maxSumLeft[0] = Integer.MIN_VALUE;
        int [] maxSumRight = new int[1];
        maxSumRight[0] = Integer.MIN_VALUE;

        Integer leftValue = maxPathSum(root.left, maxSumLeft);
        Integer rightValue = maxPathSum(root.right, maxSumRight);

        if ((leftValue == null) && (rightValue == null)) {
            maxSum[0] = root.val;
            return root.val;
        }
        if ((leftValue != null) && (rightValue != null)) {
            int sumTot = root.val + leftValue + rightValue;
            int sumLeft = root.val + leftValue;
            int sumRight = root.val + rightValue;
            int max = Math.max(Math.max(rightValue, leftValue),Math.max(Math.max(sumLeft, sumRight),Math.max(sumTot,root.val)));
            maxSum[0] = Math.max(max, Math.max(maxSumLeft[0], maxSumRight[0]));
            return Math.max(Math.max(sumLeft, sumRight),root.val);
        }
        if (leftValue != null) {
            int sumLeft = root.val + leftValue;
            int max = Math.max(Math.max(leftValue,sumLeft),root.val);
            maxSum[0] = Math.max(max, maxSumLeft[0]);
            return Math.max(sumLeft, root.val);
        }
        //righ child only
        int sumRight = root.val + rightValue;
        int max = Math.max(Math.max(rightValue,sumRight),root.val);
        maxSum[0] = Math.max(max, maxSumRight[0]);
        return Math.max(sumRight, root.val);
    }

    public static void main(String[] args) {
        TreeMaxPathSum.TreeNode treeNode = new TreeNode(1, new TreeMaxPathSum.TreeNode(2), new TreeMaxPathSum.TreeNode(3));
//        System.out.println(maxPathSum(treeNode)); //6
//
//        treeNode = new TreeNode(-3);
//        System.out.println(maxPathSum(treeNode)); //-3
//
//        treeNode = new TreeNode(1, new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null) , new TreeNode(3)),
//                new TreeNode(-3, new TreeNode(-2), null));
//        System.out.println(maxPathSum(treeNode)); //3

        treeNode = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(1),
                                null)));
        System.out.println(maxPathSum(treeNode)); //48

    }
}
