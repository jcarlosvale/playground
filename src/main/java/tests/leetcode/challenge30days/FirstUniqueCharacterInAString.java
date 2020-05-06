package tests.leetcode.challenge30days;

import java.util.*;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        Set<Character> setOfChar = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (setOfChar.add(c)) {
                map.put(c,i);
            } else {
                map.remove(c);
            }
        }
        if (map.isEmpty()) return -1;
        int pos = s.length()-1;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < pos) {
                pos = entry.getValue();
            }
        }
        return pos;
    }
}
