package tests.leetcode.challenge30days.september2022;

import tests.leetcode.challenge30days.dataStructure.TreeNode;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * 987. Vertical Order Traversal of a Binary Tree
 *
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 *
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 *
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
 *
 * Return the vertical order traversal of the binary tree.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Column -1: Only node 9 is in this column.
 * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
 * Column 1: Only node 20 is in this column.
 * Column 2: Only node 7 is in this column.
 * Example 2:
 *
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * Column -2: Only node 4 is in this column.
 * Column -1: Only node 2 is in this column.
 * Column 0: Nodes 1, 5, and 6 are in this column.
 *           1 is at the top, so it comes first.
 *           5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
 * Column 1: Only node 3 is in this column.
 * Column 2: Only node 7 is in this column.
 * Example 3:
 *
 *
 * Input: root = [1,2,3,4,6,5,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * This case is the exact same as example 2, but with nodes 5 and 6 swapped.
 * Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 1000
 *
 */
public class VerticalOrderTraversalOfABinaryTree {

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> listToReturn = new ArrayList<>();

        Map<Integer, Map<Integer, List<Integer>>> columnMap = new TreeMap<>();

        preOrder(root, 0, 0, columnMap);


        //output
        for(Map<Integer, List<Integer>> map : columnMap.values()) {
            List<Integer> listOfElementsByColumn = new ArrayList<>();
            for(List<Integer> elements : map.values()) {
                elements.sort(Comparator.comparingInt(o -> o));
                listOfElementsByColumn.addAll(elements);
            }
            listToReturn.add(listOfElementsByColumn);
        }

        return listToReturn;

    }

    private static void preOrder(TreeNode root, int row, int col, Map<Integer, Map<Integer, List<Integer>>> columnMap) {

        if (root == null) return;

        Map<Integer, List<Integer>> map = columnMap.getOrDefault(col, new TreeMap<>());
        List<Integer> list = map.getOrDefault(row, new ArrayList<>());
        list.add(root.val);
        map.put(row, list);
        columnMap.put(col, map);

        preOrder(root.left, row + 1, col - 1, columnMap);
        preOrder(root.right, row + 1, col + 1, columnMap);
    }

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7)));

        System.out.println(verticalTraversal(root));
    }

}
