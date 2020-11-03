package tests.leetcode.challenge30days.november;
/*
Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
Return the power of the string.

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5
Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11
Example 5:

Input: s = "tourist"
Output: 1


Constraints:

1 <= s.length <= 500
s contains only lowercase English letters.
 */
public class ConsecutiveCharacters {
    public static int maxPower(String s) {
        int max = 1;
        int count = 1;
        char c = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
                max = Math.max(max, count);
            } else {
                max = Math.max(max, count);
                c = s.charAt(i);
                count = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxPower("hooraaaaaaaaaaay")); //11
        System.out.println(maxPower("triplepillooooow")); //5
        System.out.println(maxPower("cc")); //2
    }
}
