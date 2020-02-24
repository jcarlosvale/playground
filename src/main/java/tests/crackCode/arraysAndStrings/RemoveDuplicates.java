package tests.crackCode.arraysAndStrings;

/*
Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer NOTE: One or two additional variables are fine
An extra copy of the array is not
FOLLOW UP
Write the test cases for this method
 */
public class RemoveDuplicates {

    public static String removeDuplicates(String word) {
        if (null == word) return null;
        char [] characters = word.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == Character.MIN_VALUE) continue;
            for (int j = i+1; j < characters.length; j++) {
                if (characters[j] == characters[i]) {
                    characters[j] = Character.MIN_VALUE;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: characters) {
            if (c != Character.MIN_VALUE) stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
