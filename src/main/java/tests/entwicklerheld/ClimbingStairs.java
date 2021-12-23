package tests.entwicklerheld;

public class ClimbingStairs {
    
    public static int climbingStairs(int numberOfStairs) {

        if(numberOfStairs <= 0) return 0;
        if (numberOfStairs <= 3) return numberOfStairs;

        int [][] pascalTriangle = createPascalTriangle(numberOfStairs);

        int count = 0;
        int k;
        int j;
        if(numberOfStairs % 2 == 0) {
            k = numberOfStairs / 2;
            j = k;
        } else {
            k = numberOfStairs / 2 + 1;
            j = k -1;
        }
        for (int i = k; i <= numberOfStairs ; i++) {
            count += pascalTriangle[i][j];
            j--;
        }
        return count;
    }

    private static int[][] createPascalTriangle(int numberOfStairs) {
        int [][] pascalTriangle = new int[numberOfStairs+1][numberOfStairs+1];

        //trivial cases:
        for (int i = 0; i <= numberOfStairs; i++) {
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;
        }

        for (int i = 2; i <= numberOfStairs; i++) {
            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j];
            }
        }
        return pascalTriangle;
    }

    public static void main(String[] args) {
        System.out.println(climbingStairs(5)); //8
    }

}