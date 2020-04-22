package tests.leetcode.challenge30days;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value <
 * node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays
 * the value of the node first, then traverses node.left, then traverses node.right.)
 *
 *
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 */
public class BinarySearchTreeFromPreorderTraversal {
    // Definition for a binary tree node.
     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


    public static TreeNode bstFromPreorder(int[] preorder) {
         TreeNode root = null;
        for(int i : preorder) {
            if (root == null) {
                root = new TreeNode(i);
            } else{
                TreeNode node = new TreeNode(i);
                insert(root, node);
            }
        }
        return root;
    }

    private static void insert(TreeNode root, TreeNode node) {
         if (node.val < root.val) {
             if (root.left == null) root.left = node;
             else insert(root.left, node);
         } else{
             if (root.right == null) root.right = node;
             else insert(root.right, node);
         }
    }

    public static void main(String[] args) {
        TreeNode root = bstFromPreorder(new int[] {8,5,1,7,10,12});
        preorder(root);
    }

    private static void preorder(TreeNode root) {
         if (root == null) {
             return;
         }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
