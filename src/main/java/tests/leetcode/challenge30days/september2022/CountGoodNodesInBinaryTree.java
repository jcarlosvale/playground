package tests.leetcode.challenge30days.september2022;

import tests.leetcode.challenge30days.dataStructure.TreeNode;
/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * Example 2:
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * Example 3:
 *
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 *
 *
 * Constraints:
 *
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
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
class CountGoodNodesInBinaryTree {

    public static int goodNodes(TreeNode root) {
        return preOrder(root, root.val - 1);
    }

    private static int preOrder(TreeNode root, int maxValue) {

        if (root == null) return 0;

        int counter = 0;

        if (root.val >= maxValue) counter++;
        maxValue = Math.max(root.val, maxValue);

        return counter + preOrder(root.left, maxValue) + preOrder(root.right, maxValue);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3,
                new TreeNode(1,
                        new TreeNode(3), null),
                new TreeNode(4,
                        new TreeNode(1), new TreeNode(5)));

        System.out.println(goodNodes(treeNode)); //4

        treeNode = new TreeNode(3,
                new TreeNode(3,
                        new TreeNode(4), new TreeNode(2)),
                null);

        System.out.println(goodNodes(treeNode)); //3

    }
}