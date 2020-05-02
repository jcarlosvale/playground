package tests.leetcode.challenge30days;

import java.util.HashMap;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 */
public class JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (counterMap.containsKey(c)) {
                counterMap.put(c, counterMap.get(c) + 1);
            } else {
                counterMap.put(c, 1);
            }
        }
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            if(counterMap.containsKey(c)) {
                count += counterMap.get(c);
            }
        }
        return count;
    }
}
