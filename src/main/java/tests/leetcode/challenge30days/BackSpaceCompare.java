package tests.leetcode.challenge30days;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a
 * backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 */
public class BackSpaceCompare {
    public static boolean backspaceCompare(String S, String T) {
        int contToken = 0;
        List<Character> listS = new ArrayList<>();
        List<Character> listT = new ArrayList<>();
        char s;
        for(int i = S.length()-1; i >= 0; i--) {
            s = S.charAt(i);
            if (s == '#') contToken++;
            else {
                if (contToken > 0) {
                    contToken--;
                } else {
                    listS.add(s);
                }
            }
        }
        contToken = 0;
        for(int i = T.length()-1; i >= 0; i--) {
            s = T.charAt(i);
            if (s == '#') contToken++;
            else {
                if (contToken > 0) {
                    contToken--;
                } else {
                    listT.add(s);
                }
            }
        }
        if (listS.size() != listT.size()) return false;
        for(int i =0; i < listS.size(); i++) {
            if (listS.get(i) != listT.get(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c","ad#c"));
        System.out.println(backspaceCompare("ab##","c#d#"));
        System.out.println(backspaceCompare("a##c","#a#c"));
        System.out.println(backspaceCompare("a#c","b"));

    }
}
