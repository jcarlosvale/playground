package tests.tipico;

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    public static int solution(String A, String B) {
        int turnsWin = 0;
        Map<Character, Integer> values = new HashMap<>();
        values.put('A', 14);
        values.put('K', 13);
        values.put('Q', 12);
        values.put('J', 11);
        values.put('T', 10);
        for (char c = '2'; c <= '9'; c++) {
            values.put(c, (int) c - '2' + 2);
        }


        for (int i = 0; i < A.length(); i++) {
            char alex = A.charAt(i);
            char bob = B.charAt(i);
            if(values.get(alex) > values.get(bob)) turnsWin++;
        }
        return turnsWin;
    }

    public static void main(String[] args) {
        System.out.println(solution("A586QK", "JJ653K")); //4
        System.out.println(solution("23A84Q", "K2Q25J")); //4
        System.out.println(solution("AAA", "AAA")); //0
    }
}
