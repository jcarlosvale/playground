package tests.facebook.interviewbits;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String A) {
        Map<Character, Integer> mapRoman = generateRomanMap();
        if (A.length() == 1) return mapRoman.get(A.charAt(0));
        int prev = mapRoman.get(A.charAt(0));
        int ans = prev;
        for (int i = 1; i < A.length(); i++) {
            int curr = mapRoman.get(A.charAt(i));
            ans += curr;
            if (curr > prev) {
                ans -= 2 * prev;
            }
            prev = curr;
        }
        return ans;
    }

    private static Map<Character, Integer> generateRomanMap() {
        Map<Character, Integer> romans = new HashMap<>();
        romans.put('M', 1000);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('I', 1);
        romans.put('V', 5);
        return romans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XXXIX")); //39
        System.out.println(romanToInt("CCXLVI")); //246
        System.out.println(romanToInt("DCCLXXXIX")); //789
        System.out.println(romanToInt("MMCDXXI")); //2421
    }
}
