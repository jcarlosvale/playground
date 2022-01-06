package tests.outros;

public class Caixeiro {

    public static int collectCoins(int [] [] matrix, int N, int M) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int up = i > 0 ? matrix[i-1][j] : -1;
                int left = j > 0 ? matrix[i][j-1] : -1;
                int higher = Math.max(up, left);
                if (higher > 0) {
                    matrix[i][j] += higher;
                }
            }
        }
        return matrix[N-1][M-1];
    }

}
