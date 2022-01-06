package tests.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class CountSubstrings {

    public static int countSubstrings(String input_str) {
        Map<Character, Integer> keyboardMap =  setupMap();
        int N = input_str.length();
        int count = 0;
        int [][] dp = new int[N][N+1];
        char [] characters = input_str.toCharArray();

        //initial values
        for (int i = 0; i < N; i++) {
            dp[i][0] = keyboardMap.get(characters[i]);
        }
        //other
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (j != 1) dp[i][j] = dp[i][j-1] + dp[i+j-1][0];
                else dp[i][j] = dp[i][0];
                //counting
                if (dp[i][j] % j == 0){
                    count ++;
                    //System.out.println(input_str.substring(i,i+j));
                }
            }
        }

        return count;
    }

    private static Map<Character, Integer> setupMap() {
        Map<Character, Integer> keyboardMap = new HashMap<>();
        keyboardMap.put('a', 1);
        keyboardMap.put('b', 1);
        keyboardMap.put('c', 2);
        keyboardMap.put('d', 2);
        keyboardMap.put('e', 2);
        keyboardMap.put('f', 3);
        keyboardMap.put('g', 3);
        keyboardMap.put('h', 3);
        keyboardMap.put('i', 4);
        keyboardMap.put('j', 4);
        keyboardMap.put('k', 4);
        keyboardMap.put('l', 5);
        keyboardMap.put('m', 5);
        keyboardMap.put('n', 5);
        keyboardMap.put('o', 6);
        keyboardMap.put('p', 6);
        keyboardMap.put('q', 6);
        keyboardMap.put('r', 7);
        keyboardMap.put('s', 7);
        keyboardMap.put('t', 7);
        keyboardMap.put('u', 8);
        keyboardMap.put('v', 8);
        keyboardMap.put('w', 8);
        keyboardMap.put('x', 9);
        keyboardMap.put('y', 9);
        keyboardMap.put('z', 9);
        return keyboardMap;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("bdh")); //4
        System.out.println(countSubstrings("abcd")); //6
        System.out.println(countSubstrings("bef")); //4

    }
}
