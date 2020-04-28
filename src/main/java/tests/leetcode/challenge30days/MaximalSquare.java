package tests.leetcode.challenge30days;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxSquare = 0;
        int lines = matrix.length;
        int columns = matrix[0].length;
        int [][] countSquare = new int[lines][columns];
        //copy last line and last column
        for(int j = 0; j < columns; j++) {
            if (matrix[lines-1][j] == '1') {
                countSquare[lines-1][j] = 1;
                maxSquare = 1;
            }
        }
        for (int i = 0; i < lines; i++) {
            if(matrix[i][columns-1] == '1') {
                countSquare[i][columns-1] = 1;
                maxSquare = 1;
            }
        }
        //iterate over the other lines and columns
        for (int i = lines-1-1; i >= 0; i--) {
            for (int j = columns-1-1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    countSquare[i][j] =
                            Math.min(Math.min(countSquare[i+1][j], countSquare[i][j+1]), countSquare[i+1][j+1]) + 1;
                    maxSquare = Math.max(maxSquare, countSquare[i][j]);
                }
            }
        }
        return maxSquare*maxSquare;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[] []{  //4
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        }));
        System.out.println(maximalSquare(new char[] []{ //9
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','1','1','1'}
        }));
        System.out.println(maximalSquare(new char[] []{ //16
                {'1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','0','0','0'},
                {'0','1','1','1','1','0','0','0'}
        }));

    }
}
