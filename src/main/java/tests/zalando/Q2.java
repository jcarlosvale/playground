package tests.zalando;

import java.util.HashMap;
import java.util.Map;

public class Q2 {
    public static int solution(String S) {
        Map<Character, Integer> mapOfChar = new HashMap<>();
        Map<Integer, Integer> mapOfCounter = new HashMap<>();
        int maxCounter = Integer.MIN_VALUE;
        int totalChar = S.length();
        int maxClasses = 0;
        //count char
        for (char c: S.toCharArray()) {
            mapOfChar.put(c, mapOfChar.getOrDefault(c, 0) + 1);
        }
        //count counter
        for (Map.Entry<Character, Integer> entry:mapOfChar.entrySet()) {
            int counter = entry.getValue();
            mapOfCounter.put(counter, mapOfCounter.getOrDefault(counter, 0) + 1);
            if (counter > maxCounter) {
                maxCounter = counter;
            }
        }
        //maxClasses
        for (Map.Entry<Integer, Integer> entry:mapOfCounter.entrySet()) {
            maxClasses = maxClasses + entry.getValue();
        }
        //verify
        int minCounter = maxCounter + (1 - maxClasses);
        int expectedOperations = 0;
        if (minCounter > 0) {
            expectedOperations = ((maxCounter + minCounter)*(maxCounter-minCounter+1)) / 2;
        } else {
            expectedOperations = ((maxCounter + 1)*(maxCounter)) / 2;
        }
        return totalChar - expectedOperations;
    }

    public static void main(String[] args) {
//        System.out.println(solution("aaaabbbb"));
//        System.out.println(solution("ccaaffddecee"));
        System.out.println(solution("eeee"));

    }
}
