package tests.leetcode.challenge30days.june;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped
 * to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
    static class Indexes {
        int i;
        int j;
        Indexes(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int lines = board.length;
        int columns = board[0].length;
        boolean[][] visited = new boolean[lines][columns];
        //up
        for (int j = 0; j < columns; j++) {
            char c = board[0][j];
            if (c == 'O') {
                dfs(0,j,board,visited);
            }
            visited[0][j] = true;
        }
        //left
        for (int i = 0; i < lines; i++) {
            char c = board[i][0];
            if (c == 'O') {
                dfs(i, 0, board,visited);
            }
            visited[i][0] = true;
        }
        //right
        for (int i = 0; i < lines; i++) {
            char c = board[i][columns-1];
            if (c == 'O') {
                dfs(i, columns-1, board,visited);
            }
            visited[i][columns-1] = true;
        }
        //down
        for (int j = 0; j < columns; j++) {
            char c = board[lines-1][j];
            if (c == 'O') {
                dfs(lines-1,j,board,visited);
            }
            visited[lines-1][j] = true;
        }

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(int i, int j, char[][] board, boolean[][] visited) {
        if (visited[i][j]) return;
        visited[i][j] = true;
        ArrayDeque<Indexes> neighbors = getNeighbors(i,j,board,visited);
        while(!neighbors.isEmpty()) {
            Indexes index = neighbors.pop();
            dfs(index.i, index.j, board, visited);
        }
    }

    private static ArrayDeque<Indexes> getNeighbors(int i, int j, char[][] board, boolean[][] visited) {
        ArrayDeque<Indexes> neighbors = new ArrayDeque();
        //up
        if (i > 0 && board[i-1][j] == 'O') {
            if (!visited[i-1][j]) neighbors.add(new Indexes(i-1,j));
        }
        //down
        if (i+1 < board.length && board[i+1][j] == 'O') {
            if (!visited[i+1][j]) neighbors.add(new Indexes(i+1,j));
        }
        //right
        if (j + 1 < board[0].length && board[i][j+1] == 'O') {
            if (!visited[i][j+1]) neighbors.add(new Indexes(i,j+1));
        }
        //left
        if (j > 0 && board[i][j-1] == 'O') {
            if (!visited[i][j-1]) neighbors.add(new Indexes(i,j-1));
        }
        return neighbors;
    }

    public static void main(String[] args) {
        char [] [] board = new char[][] {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));

        board = new char[][] {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','X','O','X'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
