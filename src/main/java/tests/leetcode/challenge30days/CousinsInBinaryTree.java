package tests.leetcode.challenge30days;

import java.util.LinkedList;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 *
 * Example 1:
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 *
 * Example 2:
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true

 * Example 3:
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Note:
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class CousinsInBinaryTree {
    public static boolean isCousins(TreeNode root, int x, int y) {
        TreeNode parentX = parent(root,x);
        TreeNode parentY = parent(root,y);
        if ((parentX == null) || (parentY == null)) return false;
        else {
            return (depth(root,x) == depth(root,y)) && (parentX.val != parentY.val);
        }
    }

    private static TreeNode parent(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return null;
        if (root.left != null && root.left.val == val) return root;
        if (root.right != null && root.right.val == val) return root;
        TreeNode parentLeft = parent(root.left, val);
        if (parentLeft == null) {
            return parent(root.right, val);
        }
        return parentLeft;
    }

    private static int depth(TreeNode root, int val) {
        if (root.val == val) return 0;
        int counter = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        counter++;
        while (!queue.isEmpty()) {
            int cont = queue.size();
            while(cont > 0) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    if (node.val == val) {
                        return counter;
                    } else {
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }
                cont--;
            }
            counter++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isCousins(new TreeNode(1,
                new TreeNode(2,
                                null,
                                new TreeNode(4)),
                        new TreeNode(3)), 2, 3));  //false
    }
}
