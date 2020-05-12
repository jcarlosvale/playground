package tests.hackerrank;

import java.util.*;

/**
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 *
 * For example , the list of all anagrammatic pairs is  at positions  respectively.
 *
 * Function Description
 *
 * Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the
 * number of anagrammatic pairs of substrings in .
 *
 * sherlockAndAnagrams has the following parameter(s):
 *
 * s: a string .
 * Input Format
 *
 * The first line contains an integer , the number of queries.
 * Each of the next  lines contains a string  to analyze.
 *
 * Constraints
 *
 *
 *
 * String  contains only lowercase letters  ascii[a-z].
 *
 * Output Format
 *
 * For each query, return the number of unordered anagrammatic pairs.
 *
 * Sample Input 0
 *
 * 2
 * abba
 * abcd
 * Sample Output 0
 *
 * 4
 * 0
 * Explanation 0
 *
 * The list of all anagrammatic pairs is  and  at positions  and  respectively.
 *
 * No anagrammatic pairs exist in the second query as no character repeats.
 *
 * Sample Input 1
 *
 * 2
 * ifailuhkqq
 * kkkk
 * Sample Output 1
 *
 * 3
 * 10
 * Explanation 1
 *
 * For the first query, we have anagram pairs  and  at positions  and  respectively.
 *
 * For the second query:
 * There are 6 anagrams of the form  at positions  and .
 * There are 3 anagrams of the form  at positions  and .
 * There is 1 anagram of the form  at position .
 *
 * Sample Input 2
 *
 * 1
 * cdcd
 * Sample Output 2
 *
 * 5
 * Explanation 2
 *
 * There are two anagrammatic pairs of length :  and .
 * There are three anagrammatic pairs of length :  at positions  respectively.
 */
public class SherlockAnagrams {
    static int sherlockAndAnagrams(String s) {
        int counter = 0;
        //size of substring
        //size
        for (int j = 1; j <= s.length(); j++) {
            //index
            for (int i = 0; i+j < s.length(); i++) {
                counter += countAnagrams(s, i, j);
            }
        }
        return counter;
    }

    private static int countAnagrams(String s, int i, int size) {
        Set<String> setOfAnagrams = new HashSet<>();
        String substring = s.substring(i, i+size);
        Map<Character, Integer> mapOfChar = countCharacters(substring);
        setOfAnagrams.add(substring);
        int counter = 0;
        //comparing partial substrings - shift
        for (int j = i+1; j+size <= s.length(); j++) {
            String analyse = s.substring(j, j + size);
            if (!setOfAnagrams.contains(analyse)) {
                if (isAnagram(mapOfChar,analyse)) {
                    setOfAnagrams.add(analyse);
                    counter++;
                }
            } else {
                counter++;
            }
        }
        return counter;
    }

    private static Map<Character, Integer> countCharacters(String string) {
        Map<Character, Integer> map = new HashMap<>();
        //map of char
        for (char c: string.toCharArray()) {
            map.put(c,map.getOrDefault(c, 1) + 1);
        }
        return map;
    }

    public static boolean isAnagram(Map<Character, Integer> mapOfAnagram, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        //map of char
        for (char c: s2.toCharArray()) {
            map.put(c,map.getOrDefault(c, 1) + 1);
        }
        //verification
        for (char c: map.keySet()) {
            if (! mapOfAnagram.getOrDefault(c,-1).equals(map.get(c))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba")); //4
        System.out.println(sherlockAndAnagrams("abcd")); //0
        System.out.println(sherlockAndAnagrams("kkkk")); //10

    }
}
