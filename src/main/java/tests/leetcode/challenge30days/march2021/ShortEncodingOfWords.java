package tests.leetcode.challenge30days.march2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3662/
A valid encoding of an array of words is any reference string s and array of indices indices such that:

words.length == indices.length
The reference string s ends with the '#' character.
For each index indices[i], the substring of s starting from indices[i] and up to (but not including) the next '#' character is equal to words[i].
Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.



Example 1:

Input: words = ["time", "me", "bell"]
Output: 10
Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"
Example 2:

Input: words = ["t"]
Output: 2
Explanation: A valid encoding would be s = "t#" and indices = [0].



Constraints:

1 <= words.length <= 2000
1 <= words[i].length <= 7
words[i] consists of only lowercase letters.
 */
public class ShortEncodingOfWords {
    public static int minimumLengthEncoding(String[] words) {
        int minLength = 0;
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        List<String> selectedWords = new ArrayList<>();
        selectedWords.add(words[0]);
        minLength = words[0].length() + 1;  // +1 to simulate # character
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (!contains(selectedWords, word)) {
                selectedWords.add(word);
                minLength += word.length() + 1; // +1 to simulate # character
            }
        }
        return minLength;
    }

    private static boolean contains(List<String> selectedWords, String word) {
        for(String s: selectedWords) {
            int length = s.length();
            int wordLength = word.length();
            if(s.substring(length-wordLength, length).compareTo(word) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"})); //10
        System.out.println(minimumLengthEncoding(new String[]{"t"})); //2
        System.out.println(minimumLengthEncoding(new String[]{"feipyxx", "e"})); //10
    }
}
