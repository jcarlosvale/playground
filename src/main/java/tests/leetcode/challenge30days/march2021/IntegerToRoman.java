package tests.leetcode.challenge30days.march2021;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3667/
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII,
which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.



Example 1:

Input: num = 3
Output: "III"
Example 2:

Input: num = 4
Output: "IV"
Example 3:

Input: num = 9
Output: "IX"
Example 4:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= num <= 3999
 */
public class IntegerToRoman {
    public static String intToRoman(int num) {
        Map<Integer, String> romanMap = new TreeMap<>(Collections.reverseOrder());
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");

        StringBuilder stringBuilder = new StringBuilder();
        while(num > 0) {
            if(romanMap.containsKey(num)) {
                stringBuilder.append(romanMap.get(num));
                num = 0;
            } else {
                for(Integer n : romanMap.keySet()) {
                    num = getRomanDigit(num, n, romanMap, stringBuilder);
                    if (num == 0) {
                        break;
                    }
                }
            }
        }
        return stringBuilder.toString();

    }

    private static int getRomanDigit(int num, Integer n, Map<Integer, String> romanMap, StringBuilder stringBuilder) {
        if (num >= n) {
            int div = num / n;
            while(div > 0) {
                stringBuilder.append(romanMap.get(n));
                div--;
            }
            return num % n;
        } else {
            return num;
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3)); //III
        System.out.println(intToRoman(4)); //IV
        System.out.println(intToRoman(9));  //IX
        System.out.println(intToRoman(58)); //LVIII
        System.out.println(intToRoman(1994)); //MCMXCIV

    }
}
