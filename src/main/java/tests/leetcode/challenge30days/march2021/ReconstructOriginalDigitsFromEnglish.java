package tests.leetcode.challenge30days.march2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3687/
Reconstruct Original Digits from English
Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending
order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc"
or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"
 */
public class ReconstructOriginalDigitsFromEnglish {
    public static String originalDigits(String s) {
        StringBuilder ans = new StringBuilder();
        Map<Integer, String> mapNumber = new HashMap<>();
        mapNumber.put(0, "zero");
        mapNumber.put(1, "one");
        mapNumber.put(2, "two");
        mapNumber.put(3, "three");
        mapNumber.put(4, "four");
        mapNumber.put(5, "five");
        mapNumber.put(6, "six");
        mapNumber.put(7, "seven");
        mapNumber.put(8, "eight");
        mapNumber.put(9, "nine");
        //map string
        Map<Character, Integer> mapWord = new HashMap<>();
        for (Character c: s.toCharArray()) {
            mapWord.merge(c, 1, (oldValue, newValue) -> oldValue+1);
        }
        //verify numbers
        while(!mapWord.isEmpty()) {
            if (mapWord.containsKey('z')) {
                removeNumber(mapWord, mapNumber.get(0));
                ans.append(0);
                continue;
            }
            if (mapWord.containsKey('w')) {
                removeNumber(mapWord, mapNumber.get(2));
                ans.append(2);
                continue;
            }
            if (mapWord.containsKey('u')) {
                removeNumber(mapWord, mapNumber.get(4));
                ans.append(4);
                continue;
            }
            if (mapWord.containsKey('g')) {
                removeNumber(mapWord, mapNumber.get(8));
                ans.append(8);
                continue;
            }
            if (mapWord.containsKey('o')) {
                removeNumber(mapWord, mapNumber.get(1));
                ans.append(1);
                continue;
            }
            if (mapWord.containsKey('r')) {
                removeNumber(mapWord, mapNumber.get(3));
                ans.append(3);
                continue;
            }
            if (mapWord.containsKey('f')) {
                removeNumber(mapWord, mapNumber.get(5));
                ans.append(5);
                continue;
            }
            if (mapWord.containsKey('v')) {
                removeNumber(mapWord, mapNumber.get(7));
                ans.append(7);
                continue;
            }
            if (mapWord.containsKey('s')) {
                removeNumber(mapWord, mapNumber.get(6));
                ans.append(6);
                continue;
            }
            if (mapWord.containsKey('i')) {
                removeNumber(mapWord, mapNumber.get(9));
                ans.append(9);
                continue;
            }
        }
        //sort
        char[] arrayOfChar = ans.toString().toCharArray();
        Arrays.sort(arrayOfChar);
        return new String(arrayOfChar);
    }

    private static void removeNumber(Map<Character, Integer> mapWord, String number) {
        for(Character c: number.toCharArray()) {
            var actual = mapWord.get(c);
            if (actual == 1) {
                mapWord.remove(c);
            } else {
                mapWord.put(c, actual-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(originalDigits("fviefuro"));
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("zeroonetwothreefourfivesixseveneightnine"));
    }
}
