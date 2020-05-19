package tests.leetcode.challenge30days.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words,
 * one of the first string's permutations is the substring of the second string.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.isEmpty() && s1.isEmpty()) return true;
        if (s1.isEmpty()) return true;
        if (s2.isEmpty()) return false;
        if (s1.length() > s2.length()) return false;
        Map<Character, Integer> countS1 = countCharacters(s1);
        int size = s1.length();
        Map<Character, Integer> countS2 = countCharacters(s2.substring(0,size));
        //first block
        if (isAnagram(countS2, countS1)) {
            return true;
        }
        //rest
        for (int i = 1; i <= s2.length()-size; i++) {
            //remove previous
            char c = s2.charAt(i-1);
            int cont = countS2.get(c) - 1;
            if (cont == 0) {
                countS2.remove(c);
            } else {
                countS2.put(c, cont);
            }
            //add next
            c = s2.charAt(i+size-1);
            cont = countS2.getOrDefault(c, 0) + 1;
            countS2.put(c,cont);
            if (isAnagram(countS2, countS1)) {
                return true;
            }
        }
        return false;
    }

    private static Map<Character, Integer> countCharacters(String string) {
        Map<Character, Integer> map = new HashMap<>();
        //map of char
        for (char c: string.toCharArray()) {
            map.put(c,map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    private static boolean isAnagram(Map<Character, Integer> s1, Map<Character, Integer> s2) {
        if (s1.size() != s2.size()) return false;
        //verification
        for (char c: s1.keySet()) {
            if (!s2.getOrDefault(c,-1).equals(s1.get(c))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

}
