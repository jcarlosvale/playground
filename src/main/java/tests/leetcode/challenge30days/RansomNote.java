package tests.leetcode.challenge30days;

import java.util.HashMap;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a
 * function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will
 * return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mapChar = new HashMap();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            mapChar.put(c, mapChar.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (mapChar.containsKey(c)) {
                mapChar.put(c, mapChar.get(c) - 1);
            }
        }
        for (Integer i : mapChar.values()) {
            if (i > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b")); //false
        System.out.println(canConstruct("aa", "ab")); //false
        System.out.println(canConstruct("aa", "aab")); //true
    }
}
