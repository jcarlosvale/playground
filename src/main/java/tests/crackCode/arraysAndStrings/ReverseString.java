package tests.crackCode.arraysAndStrings;

/*
Write code to reverse a C-Style String (C-String means that “abcd” is represented as
five characters, including the null character )
 */
public class ReverseString {

    public static String reverse(String word) {
        char [] characters = word.toCharArray();
        int start = 0;
        int end = characters.length-1;
        while (end > start) {
            char c = characters[start];
            characters[start] = characters[end];
            characters[end] = c;
            start++;
            end--;
        }
        return new String(characters);
    }
}
