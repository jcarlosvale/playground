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
        if (root == null) {
            return 0;
        }
        int leftSum = maxPathSum(root.left);
        int rightSum = maxPathSum(root.right);
        int bothSides = rightSum + leftSum + root.val;
        return Math.max(Math.max(Math.max(Math.max(leftSum, root.val + leftSum),
                        Math.max(rightSum, root.val + rightSum)), bothSides), root.val);
    }

    public static void main(String[] args) {
        TreeMaxPathSum.TreeNode treeNode = new TreeNode(1, new TreeMaxPathSum.TreeNode(2), new TreeMaxPathSum.TreeNode(3));
        System.out.println(maxPathSum(treeNode)); //6

        treeNode = new TreeNode(-3);
        System.out.println(maxPathSum(treeNode)); //6
    }
}
