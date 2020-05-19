package tests.leetcode.challenge30days.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than
 * 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexesOfAnagrams = new ArrayList<>();
        if (s.isEmpty()) return indexesOfAnagrams;
        if (p.length() > s.length()) return indexesOfAnagrams;
        Map<Character, Integer> countP = countCharacters(p);
        int size = p.length();
        Map<Character, Integer> countS = countCharacters(s.substring(0,size));
        //first block
        if (isAnagram(countP, countS)) {
            indexesOfAnagrams.add(0);
        }
        //rest
        for (int i = 1; i <= s.length()-size; i++) {
            //remove previous
            char c = s.charAt(i-1);
            int cont = countS.get(c) - 1;
            if (cont == 0) {
                countS.remove(c);
            } else {
                countS.put(c, cont);
            }
            //add next
            c = s.charAt(i+size-1);
            cont = countS.getOrDefault(c, 0) + 1;
            countS.put(c,cont);
            if (isAnagram(countP, countS)) {
                indexesOfAnagrams.add(i);
            }
        }
        return indexesOfAnagrams;
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
        System.out.println(findAnagrams("cbaebabacd", "abc")); // [0,6]
        System.out.println(findAnagrams("abab", "ab")); // [0,1,2]

    }
}
