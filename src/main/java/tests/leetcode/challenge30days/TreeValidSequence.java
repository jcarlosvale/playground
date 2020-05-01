package tests.leetcode.challenge30days;

/**
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string
 * is a valid sequence in such binary tree.
 *
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all values of
 * the nodes along a path results in a sequence in the given binary tree.
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence
 */
public class TreeValidSequence {
    /**
     * Definition for a binary tree node.
     *
     */
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

    public static boolean isValidSequence(TreeNode root, int[] arr) {
        if ((arr == null) || (arr.length == 0)) return false;
        return isValidSequence(root, arr, 0);
    }

    private static boolean isValidSequence(TreeNode root, int[] arr, int index) {
        if (root == null) return false;
        if ((index == arr.length-1) && isLeaf(root) && arr[index] == root.val) {
            return true;
        } else {
            if (index >= arr.length) {
                return false;
            }
            if (arr[index] == root.val) {
                return isValidSequence(root.left, arr, index+1) || isValidSequence(root.right, arr, index+1);
            } else {
                return false;
            }
        }
    }

    private static boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        return (root.left == null) && (root.right == null);
    }

    public static void main(String[] args) {
        int [] arr = {0,1,0,1};
        TreeValidSequence.TreeNode root = new TreeNode(0,
                new TreeNode(1,
                        new TreeNode(0,
                                null,
                                new TreeNode(1)),
                        new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(0))),
                new TreeNode(0,
                        new TreeNode(0),
                        null));
        System.out.println(isValidSequence(root, arr)); //true

        arr = new int []{0,0,1};
        root = new TreeNode(0,
                new TreeNode(1,
                        new TreeNode(0,
                                null,
                                new TreeNode(1)),
                        new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(0))),
                new TreeNode(0,
                        new TreeNode(0),
                        null));
        System.out.println(isValidSequence(root, arr)); //false

        arr = new int []{0,1,1};
        root = new TreeNode(0,
                new TreeNode(1,
                        new TreeNode(0,
                                null,
                                new TreeNode(1)),
                        new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(0))),
                new TreeNode(0,
                        new TreeNode(0),
                        null));
        System.out.println(isValidSequence(root, arr)); //false


    }
}
