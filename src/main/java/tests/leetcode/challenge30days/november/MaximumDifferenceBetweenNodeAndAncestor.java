package tests.leetcode.challenge30days.november;

import tests.leetcode.challenge30days.dataStructure.TreeNode;

/*
Given the root of a binary tree, find the maximum value V for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.



Example 1:


Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
Example 2:


Input: root = [1,null,2,null,0,3]
Output: 3


Constraints:

The number of nodes in the tree is in the range [2, 5000].
0 <= Node.val <= 105
   Hide Hint #1
For each subtree, find the minimum value and maximum value of its descendants.
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    static int maxdiff;
    public static int maxAncestorDiff(TreeNode root) {
        if (null == root) return 0;
        maxdiff = 0;
        dfs(root, root.val, root.val);
        return maxdiff;
    }

    public static void dfs(TreeNode root, int min, int max) {
        if (root == null) return;
        /**
         * Compute the difference with the root
         * */
        int diff1 = Math.abs(root.val - min);
        int diff2 = Math.abs(root.val - max);
        /**
         * find the max difference from those value
         * */
        maxdiff = Math.max(maxdiff, diff1);
        maxdiff = Math.max(maxdiff, diff2);
        /**
         * do dfs in both trees
         * */
        dfs(root.left, Math.min(min, root.val), Math.max(max, root.val));
        dfs(root.right, Math.min(min, root.val), Math.max(max, root.val));
    }
}
