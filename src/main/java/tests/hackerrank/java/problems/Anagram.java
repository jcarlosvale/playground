package tests.hackerrank.java.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-anagrams/problem
 */
public class Anagram {
    static boolean isAnagram(String firstWord, String secondWord) {
        firstWord = firstWord.toUpperCase();
        secondWord = secondWord.toUpperCase();
        boolean isAnagrams = false;
        Map<Character, Integer> map = new HashMap<>();
        if (firstWord.length() == secondWord.length()) {
            isAnagrams = true;
            for (int i = 0; i < firstWord.length(); i++) {
                map.put(firstWord.charAt(i), map.getOrDefault(firstWord.charAt(i),0)+1);
            }
            for (int i = 0; i < secondWord.length(); i++) {
                Integer cont = map.get(secondWord.charAt(i));
                if (cont == null) {
                    isAnagrams = false;
                    break;
                }
                if (cont == 1) {
                    map.remove(secondWord.charAt(i));
                } else {
                    map.put(secondWord.charAt(i), cont-1);
                }
            }
        }
        return isAnagrams && map.isEmpty();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
