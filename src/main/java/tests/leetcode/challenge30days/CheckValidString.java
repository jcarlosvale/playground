package tests.leetcode.challenge30days;

import java.util.LinkedList;

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
