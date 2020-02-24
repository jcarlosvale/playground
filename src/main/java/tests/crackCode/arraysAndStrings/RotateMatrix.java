package tests.crackCode.arraysAndStrings;

public class RotateMatrix {

    private static void swap(int [][] matrix, int i1, int j1, int i2, int j2) {
        int tmp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }

    private static void transpose(int [][] matrix) {
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    public static int[][] rotate90Degree(int[][] matrix) {
        transpose(matrix);
        int i = 0;
        int j = matrix.length-1;
        while (i < j) {
            swapColumns(matrix, i, j);
            i++;
            j--;
        }
        return matrix;
    }

    private static void swapColumns(int[][] matrix, int i, int j) {
        for(int line = 0; line < matrix.length; line ++) {
            swap(matrix, line, i, line, j);
        }
    }
}
