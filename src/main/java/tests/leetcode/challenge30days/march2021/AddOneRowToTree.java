package tests.leetcode.challenge30days.march2021;

import tests.leetcode.challenge30days.dataStructure.TreeNode;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3666/
Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given
depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes
with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of
the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If
depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole
original tree, and the original tree is the new root's left subtree.

Example 1:
Input:
A binary tree as following:
       4
     /   \
    2     6
   / \   /
  3   1 5

v = 1

d = 2

Output:
       4
      / \
     1   1
    /     \
   2       6
  / \     /
 3   1   5

Example 2:
Input:
A binary tree as following:
      4
     /
    2
   / \
  3   1

v = 1

d = 3

Output:
      4
     /
    2
   / \
  1   1
 /     \
3       1
Note:
The given d is in range [1, maximum depth of the given tree + 1].
The given binary tree has at least one tree node.
 */
public class AddOneRowToTree {
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
    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d < 1) return root;
        if (d == 1) return new TreeNode(v, root, null);

        addOneRow(root, 1, v, d);
        return root;
    }

    private static void addOneRow(TreeNode root, int currentLevel, int value, int level) {
        if (root == null) return;
        if (currentLevel == level - 1) {
            //left
            TreeNode node = new TreeNode(value);
            node.left = root.left;
            root.left = node;
            //right
            node = new TreeNode(value);
            node.right = root.right;
            root.right = node;
        } else {
            addOneRow(root.left, currentLevel+1, value, level);
            addOneRow(root.right, currentLevel+1, value, level);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(1)),
                        new TreeNode(6,
                                new TreeNode(5),
                                null));
        addOneRow(treeNode, 1, 2);

        treeNode =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                null),
                        new TreeNode(3));
        addOneRow(treeNode, 5, 4);

    }
}
