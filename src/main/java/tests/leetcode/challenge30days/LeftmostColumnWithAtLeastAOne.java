package tests.leetcode.challenge30days;

import java.util.List;

/**
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in
 * non-decreasing order.
 *
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If
 * such index doesn't exist, return -1.
 *
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 *
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that
 * attempt to circumvent the judge will result in disqualification.
 *
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will
 * not have access the binary matrix directly.
 */
public class LeftmostColumnWithAtLeastAOne {
    /**
     * // This is the BinaryMatrix's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface BinaryMatrix {
     *     public int get(int x, int y) {}
     *     public List<Integer> dimensions {}
     * };
     */
    static class BinaryMatrix {
        private int[][] matrix;
        public BinaryMatrix(int [][] matrix) {
            this.matrix = matrix;
        }
        public int get(int x, int y) {
            return matrix[x][y];
        }
        public List<Integer> dimensions() {
            return List.of(matrix.length, matrix[0].length);
        }
    };

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int lines = binaryMatrix.dimensions().get(0);
        int columns = binaryMatrix.dimensions().get(1);
        int leftColumn = findLeft1(binaryMatrix, 0, 0, columns-1);
        for (int i = 1; i < lines; i++) {
            int tempColumn = findLeft1(binaryMatrix, i, 0, columns-1);
            if (tempColumn >= 0 && tempColumn < leftColumn) {
                leftColumn = tempColumn;
            } else {
                if (leftColumn == -1) {
                    leftColumn = tempColumn;
                }
            }
        }
        return leftColumn;
    }

    private static int findLeft1(BinaryMatrix binaryMatrix, int indexLine, int start, int end) {
        if (start > end) return -1;
        int mid = (start+end) / 2;
        if (binaryMatrix.get(indexLine, mid) == 1) {
            int otherCandidate = findLeft1(binaryMatrix, indexLine, start, mid-1);
            if (otherCandidate >= 0) return otherCandidate;
            else return mid;
        }
        return findLeft1(binaryMatrix, indexLine, mid+1, end);
    }

    public static void main(String[] args) {
        System.out.println(leftMostColumnWithOne(new BinaryMatrix(new int [][]{{0,0},{1,1}})));  //0
        System.out.println(leftMostColumnWithOne(new BinaryMatrix(new int [][]{{0,0},{0,1}}))); //1
        System.out.println(leftMostColumnWithOne(new BinaryMatrix(new int [][]{{0,0},{0,0}}))); //-1
        System.out.println(leftMostColumnWithOne(new BinaryMatrix(new int [][]{{0,0,0,1},{0,0,1,1}, {0,1,1,1}}))); //1
    }

}
