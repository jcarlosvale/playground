package tests.facebook.interviewbits;

import java.util.ArrayList;
import java.util.List;

public class UniquePathsInAGrid {
    public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int lines = A.size();
        int columns = A.get(0).size();
        if ((lines == columns) && (lines == 1) && (A.get(0).get(0) == 1)) return 0;
        if ((lines == columns) && (lines == 1) && (A.get(0).get(0) == 0)) return 1;
        int [][] dp = new int[lines][columns];
        if (A.get(0).get(0) == 0) dp[0][0] = 1;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (A.get(i).get(j) != 1) {
                    if(isPossibleComesFrom(A, i-1, j)) {
                        dp[i][j] += dp[i-1][j];
                    }
                    if(isPossibleComesFrom(A, i, j-1)) {
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }
        return dp[lines-1][columns-1];
    }

    private static boolean isPossibleComesFrom(ArrayList<ArrayList<Integer>> A, int i, int j) {
        if (i < 0) return false;
        if (j < 0) return false;
        return A.get(i).get(j) != 1;
    }

    public static void main(String[] args) {
        var A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<>(List.of(0, 0)));
        System.out.println(uniquePathsWithObstacles(A)); //1
    }
}
