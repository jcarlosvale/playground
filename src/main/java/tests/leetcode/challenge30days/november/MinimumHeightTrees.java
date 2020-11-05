package tests.leetcode.challenge30days.november;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3519/
 * Minimum Height Trees
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any
 * connected graph without simple cycles is a tree.
 *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates
 * that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree
 * as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees,
 * those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 *
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 *
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 * Output: [1]
 * Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
 * Example 2:
 *
 *
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * Output: [3,4]
 * Example 3:
 *
 * Input: n = 1, edges = []
 * Output: [0]
 * Example 4:
 *
 * Input: n = 2, edges = [[0,1]]
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 104
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * All the pairs (ai, bi) are distinct.
 * The given input is guaranteed to be a tree and there will be no repeated edges.
 */
public class MinimumHeightTrees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> listMHT = new ArrayList<>();
        if (n == 1) {
            listMHT.add(0);
        } else {
            int[][] matrix = new int[n][n];
            //mount
            for (int []edge : edges) {
                int i = edge[0];
                int j = edge[1];
                matrix[i][j] = 1;
                matrix[j][i] = 1;
            }
            for (int [] edge : edges) {
                connectStep(matrix, edge[0], edge[1]);
            }
            //normalize diagonals
            for (int i = 0; i < n; i++) {
                matrix[i][i] -= 1;
            }
            //find min
            int min = n;
            for (int i = 0; i < n; i++) {
                int maxLine = -1;
                for (int j = 0; j < n; j++) {
                    maxLine = Math.max(maxLine, matrix[i][j]);
                }
                if (maxLine < min) {
                    listMHT.clear();
                    listMHT.add(i);
                    min = maxLine;
                } else {
                    if (maxLine == min) {
                        listMHT.add(i);
                    }
                }
            }
        }
        return listMHT;
    }

    private static void connectStep(int[][] matrix, int vertexA, int vertexB) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[vertexB][i] == 0 && matrix[vertexA][i] > 0) {
                matrix[vertexB][i] = matrix[vertexA][i]+1;
                matrix[i][vertexB] = matrix[vertexB][i];
            }
            if (matrix[vertexA][i] == 0 && matrix[vertexB][i] > 0) {
                matrix[vertexA][i] = matrix[vertexB][i] + 1;
                matrix[i][vertexA] = matrix[vertexA][i];
            }
        }
    }

    private static void verifyConnectivity(int[][] matrix, List<Integer> listMHT) {
        for (int i = 0; i < matrix.length; i++) {
            boolean complete = true;
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) continue;
                if (matrix[i][j] == 0) {
                    complete = false;
                    break;
                }
            }
            if (complete) listMHT.add(i);
        }
    }

    public static void main(String[] args) {
        //System.out.println(findMinHeightTrees(6, new int [][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
        System.out.println(findMinHeightTrees(15, new int [][]{{0,1},{0,2},{2,3},{2,4},{2,5},{4,6},{0,7},{4,8},{5,9},{7,10},{6,11},{0,12},{0,13},{3,14}})); //2
    }
}
