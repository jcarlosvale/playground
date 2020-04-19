package tests.leetcode.challenge30days;

import java.util.*;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * #dijkstra
 */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        boolean [] [] visited = new boolean[grid.length][grid[0].length];
        int [] [] costs = new int[grid.length][grid[0].length];
        //costs matrix
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                costs[i][j] = Integer.MAX_VALUE;
            }
        }
        //dijkstra
        return calculate(grid, costs, visited);
    }

    private static int calculate(int[][] grid, int [] [] costs, boolean [] [] visited) {
        //first node
        int i = 0;
        int j = 0;
        costs[i][j] = grid[i][j];
        visited[i][j] = true;
        updateCostOfNeighbors(i, j, grid, costs, visited);
        for(int count = 1; count < visited.length * visited[0].length; count++) {
            //select next node
            int tempCost = Integer.MAX_VALUE;
            for (int i1 = 0; i1 < grid.length; i1++) {
                for (int j1 = 0; j1 < grid[i1].length; j1++) {
                    if (visited[i1][j1]) continue;
                    if (costs[i1][j1] == Integer.MAX_VALUE) continue;
                    if (costs[i1][j1] < tempCost) {
                        i = i1;
                        j = j1;
                        tempCost = costs[i1][j1];
                    }
                }
            }
            visited[i][j] = true;
            updateCostOfNeighbors(i, j, grid, costs, visited);
        }
        return costs[grid.length-1][grid[0].length-1];
    }

    private static void updateCostOfNeighbors(int i, int j, int[][] grid, int [] [] costs, boolean [] [] visited) {
        int cost = costs[i][j];
        //right
        if (j+1 < grid[i].length) {
            int candidateCost = grid[i][j+1];
            if(!visited[i][j+1]) {
                if (costs[i][j+1] > cost + candidateCost) {
                    costs[i][j+1] = cost + candidateCost;
                }
            }
        }
        //down
        if (i+1 < grid.length) {
            int candidateCost = grid[i+1][j];
            if(!visited[i+1][j]) {
                if (costs[i+1][j] > cost + candidateCost) {
                    costs[i+1][j] = cost + candidateCost;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int [][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}}));  //1
    }
}
