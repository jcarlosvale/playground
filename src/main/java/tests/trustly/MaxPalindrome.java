package tests.trustly;/*
Palindromes are strings that read the same from the left or right, for example madam or 0110.


Given a string representing the starting number and a maximum number of changes allowed,
create the largest palindromic string of digits possible or the string -1 if it's impossible to create a palindrome under the contstraints.

Input Format

The first line contains two space-separated integers, N and K , the number of digits
in the number and the maximum number of changes allowed.

The second line contains an n-digit string of numbers.

-------

Sample Input 0

4 1
3943


Explanation:

Lots of possible outputs but most of then not being palindrome with just one change
...
9943 - Not palindrome
...
3443 - Palindrome
3993 - Palindrome
...


Sample Output 0

3993

Because despite the 2 possible outputs of palindromes the biggest one is 3993.

a) right pseudo code with the idea 
b) translate it to java code

*/

import java.util.Arrays;

public class MaxPalindrome {

    public static String maxPalindromeFromNumber(final int numberSize, int maxChangesAllowed, final String number) {
        if (numberSize % 2 != 0) return "-1";

        int requiredChangesCount = countDifferentNumbers(number);

        if (requiredChangesCount > maxChangesAllowed) return "-1";

        char[] charArray = number.toCharArray();
        //more changes than number size
        if (maxChangesAllowed >= numberSize) {
            Arrays.fill(charArray, '9');
        } else {
            int i = charArray.length / 2  - 1;
            int j = i+1;
            while((maxChangesAllowed - 2) >= requiredChangesCount) {
                if ((i < 0) || (j >= charArray.length)) break;  //indexes out of array
                //verify if it is the max digit and a single change operation
                if((charArray[i] == '9' && charArray[j] != '9') || (charArray[i] != '9' && charArray[j] == '9')) {
                    maxChangesAllowed--;
                    requiredChangesCount--;
                //bonus increasing the number, modifying freely the number
                } else {
                    maxChangesAllowed -= 2;
                }
                charArray[i] = '9';
                charArray[j] = '9';
                i--;
                j++;
            }
            //minimum change, maxChangesAllowed == requiredChanges at least, palindrome algorithm modifying values
            int size = charArray.length;
            for(i = 0; i < size / 2; i++) {
                j = size-i-1;
                if (charArray[i] != charArray[j]) {
                    if(charArray[i] > charArray[j]) {
                        charArray[j] = charArray[i];
                    } else {
                        charArray[i] = charArray[j];
                    }
                }
            }
        }
        return new String(charArray);
    }

    private static int countDifferentNumbers(String number) {
        int count = 0;
        int size = number.length();
        for(int i = 0; i < size / 2; i++) {
            if (number.charAt(i) != number.charAt(size-i-1)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxPalindromeFromNumber(4, 1, "3943")); //3993
        System.out.println(maxPalindromeFromNumber(4, 4, "3943")); //9999
        System.out.println(maxPalindromeFromNumber(4, 3, "3943")); //9999
        System.out.println(maxPalindromeFromNumber(4, 2, "1234")); //4334
    }

}