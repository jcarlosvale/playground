package tests.leetcode.challenge30days;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary
 * representation.
 *
 *
 *
 * Example 1:
 *
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need
 * to output 2.
 *
 *
 * Example 2:
 *
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to o
 */
public class NumberComplement {
    public static int findComplement(int num) {
        StringBuilder buffer = new StringBuilder(Integer.toBinaryString(num));
        for (int i = 0; i <buffer.length(); i++) {
            char c = buffer.charAt(i) == '1' ? '0' : '1';
            buffer.setCharAt(i, c);
        }
        return Integer.valueOf(buffer.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5)); //2
        System.out.println(findComplement(1)); //0
    }
}
