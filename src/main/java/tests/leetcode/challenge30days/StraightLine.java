package tests.leetcode.challenge30days;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */
public class StraightLine {
    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;
        //colineares
        if ((coordinates[1][0] - coordinates[0][0]) != 0) {
            int a = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
            int b = coordinates[0][1] - a * coordinates[0][0];
            for(int i = 2; i < coordinates.length; i++) {
                int y = a * coordinates[i][0] + b;
                if (y != coordinates[i][1]) return false;
            }
        } else {
            for(int i = 2; i < coordinates.length; i++) {
                if(coordinates[i][0] != coordinates[1][0]) return false;
            }
        }
        return true;
    }
}
