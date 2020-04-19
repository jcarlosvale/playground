package tests.leetcode.challenge30days;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the
 * number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1
 * are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return isHappy(n, set);
    }

    private static boolean isHappy(int n, Set<Integer> set) {
        if (set.contains(n)) return false;
        else {
            set.add(n);
            String strNumber = String.valueOf(n);
            int sum = 0;
            for(int i = 0; i < strNumber.length(); i++) {
                int digit = Integer.parseInt(strNumber.substring(i,i+1));
                sum += (digit * digit);
            }
            if (sum == 1) return true;
            return isHappy(sum, set);
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
