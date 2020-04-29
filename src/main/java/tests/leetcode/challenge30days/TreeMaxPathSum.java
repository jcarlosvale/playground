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
        int sum = root.val;
        int bothSides = root.val;
        if (root.left != null) {
            int leftSum = maxPathSum(root.left);
            sum = Math.max(leftSum, root.val + leftSum);
            bothSides += leftSum;
        }
        if (root.right != null) {
            int rightSum = maxPathSum(root.right);
            sum = Math.max(sum, Math.max(rightSum, root.val + rightSum));
            bothSides += rightSum;
        }
        return Math.max(Math.max(root.val, bothSides), sum);
    }

    public static void main(String[] args) {
        TreeMaxPathSum.TreeNode treeNode = new TreeNode(1, new TreeMaxPathSum.TreeNode(2), new TreeMaxPathSum.TreeNode(3));
        System.out.println(maxPathSum(treeNode)); //6

        treeNode = new TreeNode(-3);
        System.out.println(maxPathSum(treeNode)); //-3

        treeNode = new TreeNode(1, new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null) , new TreeNode(3)),
                new TreeNode(-3, new TreeNode(-2), null));
        System.out.println(maxPathSum(treeNode)); //3

    }
}
