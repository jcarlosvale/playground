package tests.entwicklerheld;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleJava {
    public static List<Long> getPascalsTriangleRow(int rowNumber) {
        long [][] pascalTriangle = new long[rowNumber+1][rowNumber+1];

        //trivial cases:
        for (int i = 0; i <= rowNumber; i++) {
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;
        }

        for (int i = 2; i <= rowNumber; i++) {
            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j];
            }
        }

        List<Long> triangleRow = new ArrayList<>();
        for(long i: pascalTriangle[rowNumber]) {
            if (i > 0) triangleRow.add(i);
        }
        return triangleRow;
    }
}