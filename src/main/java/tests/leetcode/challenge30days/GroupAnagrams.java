package tests.leetcode.challenge30days;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> anagramsMap = new HashMap<>();
        //iterate over word
        for(String word : strs) {
            //mount map of char
            Map<Character, Integer> charCountMap = new HashMap<>();
            for(int index = 0; index < word.length(); index ++) {
                char c = word.charAt(index);
                if (charCountMap.containsKey(c)) {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } else {
                    charCountMap.put(c,1);
                }
            }
            //verify anagrams map
            if (anagramsMap.containsKey(charCountMap)) {
                anagramsMap.get(charCountMap).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                anagramsMap.put(charCountMap, list);
            }
        }
        return new ArrayList<>(anagramsMap.values());
    }

    public static void main(String[] args) {
        List<List<String>> result = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for(List<String> list:result) {
            System.out.println(list);
        }
    }
}
