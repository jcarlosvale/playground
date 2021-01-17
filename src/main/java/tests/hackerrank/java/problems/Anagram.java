package tests.hackerrank.java.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
https://www.hackerrank.com/challenges/java-anagrams/problem
 */
public class Anagram {
    static boolean isAnagram(String a, String b) {
        a = a.toUpperCase();
        b = b.toUpperCase();
        boolean isAnagrams = false;
        Map<Character, Integer> map = new HashMap<>();
        if (a.length() == b.length()) {
            isAnagrams = true;
            for (int i = 0; i < a.length(); i++) {
                map.put(a.charAt(i), map.getOrDefault(a.charAt(i),0)+1);
            }
            for (int i = 0; i < b.length(); i++) {
                Integer cont = map.get(b.charAt(i));
                if (cont == null) {
                    isAnagrams = false;
                    break;
                }
                if (cont == 1) {
                    map.remove(b.charAt(i));
                } else {
                    map.put(b.charAt(i), cont-1);
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
