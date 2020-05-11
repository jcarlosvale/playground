package tests.hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 *
 * For example, the words "a", "and", "art" share the common substring . The words "be" and "cat" do not share a
 * substring.
 *
 * Function Description
 *
 * Complete the function twoStrings in the editor below. It should return a string, either YES or NO based on whether
 * the strings share a common substring.
 *
 * twoStrings has the following parameter(s):
 *
 * s1, s2: two strings to analyze .
 * Input Format
 *
 * The first line contains a single integer , the number of test cases.
 *
 * The following  pairs of lines are as follows:
 *
 * The first line contains string .
 * The second line contains string .
 * Constraints
 *
 *  and  consist of characters in the range ascii[a-z].
 * Output Format
 *
 * For each pair of strings, return YES or NO.
 *
 * Sample Input
 *
 * 2
 * hello
 * world
 * hi
 * world
 * Sample Output
 *
 * YES
 * NO
 * Explanation
 *
 * We have  pairs to check:
 *
 * , . The substrings  and  are common to both strings.
 * , .  and  share no common substrings.
 */
public class TwoStrings {
    static String twoStrings(String s1, String s2) {
        boolean found = false;
        if (s1.length() < s2.length()) {
            found = existCommomSubstring(s1,s2);
        } else {
            found = existCommomSubstring(s2,s1);
        }
        if (found) return "YES";
        else return "NO";
    }

    private static boolean existCommomSubstring(String s1, String s2) {
        Set<Character> setOfChar = new HashSet<>();
        char[] arrayOfChar = s1.toCharArray();
        for (char c: arrayOfChar) {
            setOfChar.add(c);
        }
        return setOfChar.stream().anyMatch(character -> s2.indexOf(character) >= 0);
    }
}
