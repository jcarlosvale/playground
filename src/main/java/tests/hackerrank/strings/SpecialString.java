package tests.hackerrank.strings;

public class SpecialString {
    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long [] [] dp = new long[n][n];
        long count = 0;
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            for (int j = 0; j < n; j++) {
                char c2 = s.charAt(j);
                if(c1 == c2) {
                    dp[i][j] = 1 + ((i > 0 && j < n-1) ? dp[i-1][j+1] : 0);
                }
                //verifying size of special
                if (dp[i][j] > 2 && dp[i][j] != dp[i-1][j]){
                    count++;
                }
                if (dp[i][j] == 2 && s.charAt(i) == s.charAt(i-1) && dp[i][j] != dp[i-1][j]) {
                    count++;
                }
            }
        }
        return count + n;
    }

    public static void main(String[] args) {
//        System.out.println(substrCount(8, "mnonopoo"));//12
//        System.out.println(substrCount(5, "asasd")); //7
//        System.out.println(substrCount(4, "aaaa")); //10
        System.out.println(substrCount(7, "abcbaba")); //10


    }
}
