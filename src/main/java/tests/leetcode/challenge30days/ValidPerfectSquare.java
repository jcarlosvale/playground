package tests.leetcode.challenge30days;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 */
public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        //using subtractions of odd numbers
        int i = 1;
        while(num > 0) {
            num = num - i;
            i = i+2;
        }
        return (num == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}
