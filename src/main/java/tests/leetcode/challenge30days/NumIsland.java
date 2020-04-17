package tests.leetcode.challenge30days;

import java.util.*;

public class NumIsland {
    static class Indexes {
        int i;
        int j;
        Indexes(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int lines = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                char element = grid[i][j];
                if (element == '1' && !visited[i][j]) {
                    dfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (visited[i][j]) return;
        visited[i][j] = true;
        LinkedList<Indexes> nodes = getNeighbors(i,j,grid,visited);
        while(!nodes.isEmpty()) {
            Indexes node = nodes.removeFirst();
            dfs(node.i, node.j, grid, visited);
        }
    }

    private static LinkedList<Indexes> getNeighbors(int i, int j, char[][] grid, boolean[][] visited) {
        LinkedList<Indexes> neighbors = new LinkedList<>();
        //up
        if (i > 0 && grid[i - 1][j] == '1') {
            if (!visited[i-1][j]) neighbors.add(new Indexes(i-1,j));
        }
        //down
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            if (!visited[i+1][j]) neighbors.add(new Indexes(i+1,j));
        }
        //right
        if (j + 1 < grid[0].length && grid[i][j+1] == '1') {
            if (!visited[i][j+1]) neighbors.add(new Indexes(i,j+1));
        }
        //left
        if (j > 0 && grid[i][j-1] == '1') {
            if (!visited[i][j-1]) neighbors.add(new Indexes(i,j-1));
        }
        return neighbors;
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char [][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}}));  //1
        System.out.println(numIslands(new char [][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}})); //3

        System.out.println(numIslands(new char [][] {
                {'1'},
                {'1'}})); //1

        System.out.println(numIslands(new char [][] {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}})); //1

        System.out.println(numIslands(new char [][] {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}})); //1

    }
}
