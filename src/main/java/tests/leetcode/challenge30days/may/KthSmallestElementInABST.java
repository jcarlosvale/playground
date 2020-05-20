package tests.leetcode.challenge30days.may;

import lombok.val;
import tests.leetcode.challenge30days.dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How
 * would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInABST {
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            return inOrderIterative(root, k);
        }

        private int inOrderIterative(TreeNode root, int k) {
            TreeNode curr = root;
            Deque<TreeNode> stack = new ArrayDeque<>();
            while(curr != null || !stack.isEmpty()) {
                //left
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                //action
                curr = stack.pop();
                k = k - 1;
                if (k == 0) {
                    return curr.val;
                }
                //right
                curr = curr.right;
            }
            return 0;
        }
    }
}
