package tests.leetcode.challenge30days;

import java.util.LinkedList;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this
 * string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 */
public class CheckValidString {
    public static boolean checkValidString(String s) {
        LinkedList<Integer> stackToken = new LinkedList<>();
        LinkedList<Integer> stackAsterisks = new LinkedList<>();
        int[] countRemainder = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stackAsterisks.add(i);
                countRemainder[i] = -1;
            }
            if (c == '(') {
                stackToken.addFirst(i);
                countRemainder[i] = +1;
            }
            if (c == ')') {
                if (!stackToken.isEmpty()) {
                    int pos = stackToken.removeFirst();
                    countRemainder[pos] = 0;
                } else{
                    if (!stackAsterisks.isEmpty()) {
                        int pos = stackAsterisks.removeFirst();
                        countRemainder[pos] = 0;
                    } else {
                        return false;
                    }
                }
            }
        }

        if (stackToken.isEmpty()) return true;

        //remainder "("
        int cont= 0;
        for (int i = 0; i < countRemainder.length; i++) {
            if(countRemainder[i] < 0) {
                if (cont > 0) cont--;
            }
            if (countRemainder[i] > 0) {
                cont ++;
            }
        }
        return cont == 0 ;

    }

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));  //t
        System.out.println(checkValidString("(*)")); //t
        System.out.println(checkValidString("(*))")); //t
        System.out.println(checkValidString("(*()")); //t
        System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*")); //f

    }
}
