package tests.leetcode.challenge30days;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number
 * is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        if (k == 0) return num;
        int size = num.length() - k;
        int startIndex = 0;
        int endIndex;
        char[] arrayOfChar = num.toCharArray();
        char[] selectedChar = new char[size];
        int indexNewString = 0;
        while (size > 0) {
            endIndex = num.length() - size;
            //find lower digit
            char c = '9';
            int index = startIndex;
            for(int i = startIndex; i<= endIndex; i++) {
                if (arrayOfChar[i] < c) {
                    c = arrayOfChar[i];
                    index = i;
                }
            }
            selectedChar[indexNewString] = c;
            startIndex = index + 1;
            indexNewString++;
            size--;
        }
        //remove leading zeros
        boolean allZero = true;
        for (int i = 0; i < selectedChar.length; i++) {
            if (selectedChar[i] == '0') {
                selectedChar[i] = 0;
            } else {
                allZero = false;
                break;
            }
        }
        if (allZero) return "0";
        else return new String(selectedChar).trim();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3)); // 1219
        System.out.println(removeKdigits("10200", 1)); // 200
        System.out.println(removeKdigits("10", 2)); // 0
    }
}
