package tests.trivago;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Leave UNIQUE the counting of characters.
 */
public class Q1 {


    public static int solution(String S) {
        char[] array = S.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        //count
        for(char c : array) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        //eliminate
        Set<Integer> usedSizes = new HashSet<>();
        Set<Integer> notAllowed = new HashSet<>();
        int count = 0;
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            int counter = entry.getValue();
            if (notAllowed.contains(counter)) {
                count += counter;
            } else {
                int originalCounter = counter;
                while(counter > 0) {
                    if (usedSizes.contains(counter)) {
                        if (notAllowed.contains(counter-1)) {
                            notAllowed.add(counter);
                            count += counter;
                            break;
                        } else {
                            count++;
                            counter--;
                        }
                    } else {
                        usedSizes.add(counter);
                        break;
                    }
                }
                if (counter == 0) {
                    notAllowed.add(originalCounter);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("aaaabbbb")); //1
        System.out.println(solution("eeeee")); //0
        System.out.println(solution("example")); //4
        System.out.println(solution("ccaaffddecee")); //6

    }
}
