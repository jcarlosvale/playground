package tests.facebook.interviewbits;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import tests.leetcode.challenge30days.dataStructure.TreeNode;
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> nodesToVisit = new LinkedList<>();
        LinkedList<Integer> levelsToVisit = new LinkedList<>();
        if (A != null) {
            nodesToVisit.add(A);
            levelsToVisit.add(0);
        }
        while(!nodesToVisit.isEmpty()) {
            TreeNode node = nodesToVisit.getFirst();
            Integer level = levelsToVisit.getFirst();

            if (ans.size()-1 < level) {
                ans.add(new ArrayList<>());
            }
            ans.get(level).add(node.val);

            nodesToVisit.removeFirst();
            levelsToVisit.removeFirst();

            if (node.left != null) {
                nodesToVisit.add(node.left);
                levelsToVisit.add(level+1);
            }
            if (node.right != null) {
                nodesToVisit.add(node.right);
                levelsToVisit.add(level+1);
            }
        }
        return ans;
    }
}
