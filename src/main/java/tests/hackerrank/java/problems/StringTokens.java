package tests.hackerrank.java.problems;

import java.util.Scanner;

public class StringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        s = removeLeadingNonLetters(s);
        if (s.length() == 0) {
            System.out.println(0);
            return;
        }
        String[] result = s.split("[^a-zA-Z]+");
        System.out.println(result.length);
        for (String s1 : result) {
            System.out.println(s1);
        }
        scan.close();
    }

    private static String removeLeadingNonLetters(String str) {
        int i;
        for (i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                break;
            }
        }
        return str.substring(i);
    }
}
