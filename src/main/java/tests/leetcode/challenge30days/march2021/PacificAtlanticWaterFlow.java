package tests.leetcode.challenge30days.march2021;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3684/
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

The order of returned grid coordinates does not matter.
Both m and n are less than 150.


Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 https://null00.medium.com/leetcode-pacific-atlantic-water-flow-62e90fe1bb03
 */
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        if (n == 0) return res;

        boolean[][] pvisited = new boolean[m][n];
        boolean[][] avisited = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            dfs(i, 0, m, n, pvisited, matrix, Integer.MIN_VALUE);
            dfs(i, n - 1, m, n, avisited, matrix, Integer.MIN_VALUE);
        }

        for (int i = 0; i < n; ++i) {
            dfs(0, i, m, n, pvisited, matrix, Integer.MIN_VALUE);
            dfs(m - 1, i, m, n, avisited, matrix, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (pvisited[i][j] && avisited[i][j]) {
                    List<Integer> subRes = new ArrayList<Integer>();
                    subRes.add(i);
                    subRes.add(j);
                    res.add(subRes);
                }

        return res;
    }

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private void dfs(int x, int y, int m, int n, boolean[][] visited, int[][] matrix, int height) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for (int[] d : dirs)
            dfs(x + d[0], y + d[1], m, n, visited, matrix, matrix[x][y]);
    }
}
