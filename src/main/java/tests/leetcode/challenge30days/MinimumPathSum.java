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

    static class Indexes {
        int i;
        int j;
        Indexes(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Indexes indexes = (Indexes) o;
            return i == indexes.i && j == indexes.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public static int minPathSum(int[][] grid) {
        Map<Indexes,Integer> mapOfCosts = new HashMap<>();
        //costs matrix
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                mapOfCosts.put(new Indexes(i,j), Integer.MAX_VALUE);
            }
        }
        //dijkstra
        return calculate(grid, mapOfCosts);
    }

    private static int calculate(int[][] grid, Map<Indexes, Integer> mapOfCosts) {
        Set<Indexes> visited = new HashSet<>();
        //first node
        mapOfCosts.put(new Indexes(0,0),grid[0][0]);
        visited.add(new Indexes(0,0));
        Set<Indexes> neighbors = getNeihgborsWithUpdatedCost(0, 0, grid, mapOfCosts, visited);
        while(!neighbors.isEmpty()) {
            Indexes node = selectNextNode(neighbors, mapOfCosts);
            visited.add(node);
            neighbors.addAll(getNeihgborsWithUpdatedCost(node.i, node.j, grid, mapOfCosts, visited));
            neighbors.remove(node);
        }
        return mapOfCosts.get(new Indexes(grid.length-1, grid[0].length-1));
    }

    private static Indexes selectNextNode(Set<Indexes> neighbors, Map<Indexes, Integer> mapOfCosts) {
        PriorityQueue<Indexes> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(mapOfCosts::get));
        priorityQueue.addAll(neighbors);
        return priorityQueue.poll();
    }

    private static Set<Indexes> getNeihgborsWithUpdatedCost(int i, int j, int[][] grid,
                                                             Map<Indexes, Integer> mapOfCosts, Set<Indexes> visited) {
        int cost = mapOfCosts.get(new Indexes(i,j));
        Set<Indexes> neighbors = new HashSet<>();
        //right
        if (j+1 < grid[i].length) {
            Indexes candidate = new Indexes(i, j + 1);
            int candidateCost = grid[i][j+1];
            if(!visited.contains(candidate)) {
                if (mapOfCosts.get(candidate) > cost + candidateCost) {
                    mapOfCosts.put(candidate, cost + candidateCost);
                }
                neighbors.add(candidate);
            }
        }
        //down
        if (i+1 < grid.length) {
            Indexes candidate = new Indexes(i+1, j);
            int candidateCost = grid[i+1][j];
            if(!visited.contains(candidate)) {
                if (mapOfCosts.get(candidate) > cost + candidateCost) {
                    mapOfCosts.put(candidate, cost + candidateCost);
                }
                neighbors.add(candidate);
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int [][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}}));  //1
    }
}
