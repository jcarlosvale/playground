package tests.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;

public class MakeAnagram {
    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
        // Write your code here
        Map<Character, Integer> counterMap = new HashMap<>();
        for(char c: a.toCharArray()) {
            counterMap.put(c, counterMap.getOrDefault(c, 0) + 1);
        }
        for(char c: b.toCharArray()) {
            counterMap.put(c, counterMap.getOrDefault(c, 0) - 1);
        }
        int count = 0;
        for(int i : counterMap.values()) {
            count += Math.abs(i);
        }
        return count;
    }
}
