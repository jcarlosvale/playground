package tests.crackCode.arraysAndStrings;

/*
Implement an algorithm to determine if a string has all unique characters What if
you can not use additional data structures?
 */
public class UniqueCharacters {

    public static boolean verify(String word) {
        boolean [] unique = new boolean[Character.MAX_VALUE+1];
        for(int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (unique[c]) return false;
            unique[c] = true;
        }
        return true;
    }
}
