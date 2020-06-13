package tests.hackerrank.certification;

import java.util.LinkedList;

public class PasswordDecryption {

    public static String decryptPassword(String s) {
        LinkedList<Character> stackNumbers = new LinkedList<>();
        char [] arrayOfChar = s.toCharArray();
        char [] arrayToReturn = new char[s.length()];
        //block of numbers
        int j = 0;
        int i = 0;
        while(arrayOfChar[i] > '0' && arrayOfChar[i] <= '9') {
            stackNumbers.push(arrayOfChar[i]);
            i++;
        }
        //text
        while(i < arrayOfChar.length) {
            char c = arrayOfChar[i];
            if (c == '*') {
                //swap
                c = arrayToReturn[j-1];
                arrayToReturn[j-1] = arrayToReturn[j-2];
                arrayToReturn[j-2] = c;
            } else {
                if (c == '0') {
                    if (!stackNumbers.isEmpty()) {
                        arrayToReturn[j] = stackNumbers.pop();
                    }
                } else {
                    arrayToReturn[j] = arrayOfChar[i];
                }
                j++;
            }
            i++;
        }
        return new String(arrayToReturn).trim();
    }

    public static void main(String[] args) {
        System.out.println(decryptPassword("51Pa*0Lp*0e")); //aP1pL5e
        System.out.println(decryptPassword("000000")); //empty
    }

}
