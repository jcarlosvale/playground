package tests.leetcode.challenge30days.march2021;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3686/
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same
characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".


Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Note:

The input string length won't exceed 1000.


   Hide Hint #1
How can we reuse a previously computed palindrome to compute a larger palindrome?
   Hide Hint #2
If “aba” is a palindrome, is “xabax” and palindrome? Similarly is “xabay” a palindrome?
   Hide Hint #3
Complexity based hint:
If we use brute-force and check whether for every start and end position a substring is a palindrome we have O(n^2)
start - end pairs and O(n) palindromic checks. Can we reduce the time for palindromic checks to O(1) by reusing some
previous computation?
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int N = s.length();
        int ans = 0;
        for (int center = 0; center <= 2 * N - 1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
