package tests.leetcode.challenge30days.march2021;

import tests.leetcode.challenge30days.dataStructure.TreeNode;

import java.util.*;

/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageLevelsInBinaryTree {
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
    public static List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Integer>> mapLevels = new TreeMap<>();
        int level = 0;
        fillByLevel(root, 0, mapLevels);
        //average
        List<Double> average = new ArrayList<>();
        for(List<Integer> listOfInteger: mapLevels.values()) {
            double sum = listOfInteger.stream().mapToDouble(value -> (double) value).sum();
            average.add(sum / listOfInteger.size());
        }
        return average;
    }

    private static void fillByLevel(TreeNode node, int level, Map<Integer, List<Integer>> mapLevels) {
        if (node == null) return;
        List<Integer> listValue = mapLevels.getOrDefault(level, new ArrayList<>());
        listValue.add(node.val);
        mapLevels.put(level, listValue);
        fillByLevel(node.left, level+1, mapLevels);
        fillByLevel(node.right, level+1, mapLevels);
    }

    public static void main(String[] args) {
        System.out.println(averageOfLevels(new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)))));
    }
}
