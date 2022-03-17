package tests.facebook.interviewbits;

import java.util.LinkedList;
import java.util.Stack;
import tests.leetcode.challenge30days.dataStructure.TreeNode;

public class BSTIterator {

    LinkedList<Integer> linkedList = new LinkedList<>();

    BSTIterator(TreeNode root) {
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        linkedList.add(root.val);
        inOrder(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !linkedList.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return linkedList.removeFirst();
    }
}
