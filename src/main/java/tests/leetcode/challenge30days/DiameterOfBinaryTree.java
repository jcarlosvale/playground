package tests.leetcode.challenge30days;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class DiameterOfBinaryTree {
    public static int diameterOfBinaryTree(TreeNode root) {
        if (null == root) return 0;

        int left = deep(root.left);
        int right = deep(root.right);

        int lDiameter = diameterOfBinaryTree(root.left);
        int rDiameter = diameterOfBinaryTree(root.right);

        return Math.max(left+right, Math.max(lDiameter, rDiameter));
    }

    private static int deep(TreeNode root) {
        if (null == root) return 0;
        return (1 + Math.max(deep(root.left), deep(root.right)));
    }

    public static void main(String[] args) {
        TreeNode tree   = new TreeNode(1);
        tree.left       = new TreeNode(2);
        tree.right      = new TreeNode(3);
        tree.left.left  = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(tree));
    }
}