package tests.entwicklerheld;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int value = grid[i][j] - '0';
                if (value == 1) {
                    if (sumNeighbors(grid, i, j) == 0) { //border
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static int sumNeighbors(char[][] grid, int i, int j) {
        int leftValue = j == 0 ? 0 : grid[i][j-1] - '0';
        int upValue = i == 0 ? 0 : grid[i-1][j] - '0';
        return leftValue + upValue;
    }

    public static void main(String[] args) {
//        System.out.println(numIslands(new char[][]{{'0','0','0','0'}, {'0','0','0','0'}, {'0','0','0','0'}})); //0
//        System.out.println(numIslands(new char[][]{{'1','1','1','1'}, {'1','1','1','1'}, {'1','1','1','1'}}));  //1
//        System.out.println(numIslands(new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}}));  //3
        System.out.println(numIslands(new char[][]{{'1','1','1'}, {'0','1','0'}, {'1','1','1'}})); //1
    }
}