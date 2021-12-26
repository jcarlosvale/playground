package tests.entwicklerheld;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;
        int [][]visited = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                int value = grid[i][j] - '0';
                if (value == 1) {
                     if (visited[i][j] != 1) {
                         count++;
                     }
                     markConnections(grid, i, j, grid.length, grid[i].length, visited);
                }
                visited[i][j] = 1;
            }
        }
        return count;
    }

    private static void markConnections(char[][] grid, int i, int j, int lineNum, int columnNum, int[][] visited) {
        if (visited[i][j] != 1 && grid[i][j] == '1') {
            visited[i][j] = 1;
            //UP
            if (i > 0) {
                markConnections(grid, i-1, j, lineNum, columnNum, visited);;
            }
            //DOWN
            if (i < lineNum-1) {
                markConnections(grid, i+1, j, lineNum, columnNum, visited);;
            }
            //LEFT
            if (j > 0) {
                markConnections(grid, i, j-1, lineNum, columnNum, visited);;
            }
            //RIGHT
            if (j < columnNum - 1) {
                markConnections(grid, i, j+1, lineNum, columnNum, visited);;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(numIslands(new char[][]{{'0','0','0','0'}, {'0','0','0','0'}, {'0','0','0','0'}})); //0
//        System.out.println(numIslands(new char[][]{{'1','1','1','1'}, {'1','1','1','1'}, {'1','1','1','1'}}));  //1
//        System.out.println(numIslands(new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}}));  //3
        System.out.println(numIslands(new char[][]{{'1','1','1'}, {'0','1','0'}, {'1','1','1'}})); //1
    }
}