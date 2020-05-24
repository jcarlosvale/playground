package tests.leetcode.challenge30days.may;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 */
public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        if (s.isEmpty()) return s;
        TreeMap<Character, Integer> countMap = new TreeMap<>();
        TreeMap<Integer, List<Character>> mapToPrint = new TreeMap<>();
        //count
        for(char c: s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        //sort
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            List<Character> list = mapToPrint.get(entry.getValue());
            if (list == null) list = new ArrayList<>();
            list.add(entry.getKey());
            mapToPrint.put(entry.getValue(), list);
        }
        //print
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer i : mapToPrint.descendingKeySet()) {
            for(char c: mapToPrint.get(i)) {
                int count = i;
                while(count>0) {
                    stringBuilder.append(c);
                    count--;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
