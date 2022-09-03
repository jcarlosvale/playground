package tests.leetcode.challenge30days.binaryTree;

import tests.leetcode.challenge30days.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * # 637. Average of Levels in Binary Tree
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Example 2:
 *
 *
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 *
 */

public class AverageOfLevelsInBinaryTree {

    public static List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();

        //root
        level.add(root);

        while(!level.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            double sum = 0;

            for(TreeNode node : level) {
                sum += node.val;
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }

            result.add(sum / level.size());
            level = nextLevel;

        }

        return result;

    }


}
