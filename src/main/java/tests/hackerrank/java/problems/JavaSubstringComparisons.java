package tests.hackerrank.java.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-string-compare/problem
 */
public class JavaSubstringComparisons {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        java.util.List<String> strings = new ArrayList<>();
        for (int i = 0; i < (s.length()-k+1); i++) {
            strings.add(s.substring(i, i+k));
        }
        Collections.sort(strings);
        smallest = strings.get(0);
        largest = strings.get(strings.size()-1);

        return smallest + "\n" + largest;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
