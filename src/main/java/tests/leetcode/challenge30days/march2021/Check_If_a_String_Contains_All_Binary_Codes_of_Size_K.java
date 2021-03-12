package tests.leetcode.challenge30days.march2021;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3669/
 Given a binary string s and an integer k.

Return True if every binary code of length k is a substring of s. Otherwise, return False.



Example 1:

Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indicies 0, 1, 3 and 2 respectively.
Example 2:

Input: s = "00110", k = 2
Output: true
Example 3:

Input: s = "0110", k = 1
Output: true
Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
Example 4:

Input: s = "0110", k = 2
Output: false
Explanation: The binary code "00" is of length 2 and doesn't exist in the array.
Example 5:

Input: s = "0000000001011100", k = 4
Output: false


Constraints:

1 <= s.length <= 5 * 10^5
s consists of 0's and 1's only.
1 <= k <= 20
 */
public class Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
    public static boolean hasAllCodes(String s, int k) {
        Set<Integer> binaryNumbers = new HashSet<>();
        if(s.length() <= k) return false;
        for (int i = k-1; i < s.length(); i++) {
            String piece = s.substring(i-k+1, i+1);
            binaryNumbers.add(Integer.parseInt(piece, 2));
        }
        if (binaryNumbers.size() < Math.pow(2,k)) return false;
        return true;
    }

    public static void main(String[] args) {
       // System.out.println(hasAllCodes("00110110",2)); //true
        System.out.println(hasAllCodes("00000000001011100",3)); //true
    }
}
