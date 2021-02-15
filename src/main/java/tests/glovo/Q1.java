package tests.glovo;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    //TIME: O(n)
    //SPACE: O(n)
    public static Character solution(String string) {
        Map<Character, Integer> countElementsMap = new HashMap<>();
        Map<Character, Integer> mapPosition = new HashMap<>();

        //counting ABCABC...
        for (int i = 0; i < string.length(); i++) {

            char c = string.charAt(i);

            int count = countElementsMap.getOrDefault(c, 0);
            count++;
            countElementsMap.put(c, count);

            if (!mapPosition.containsKey(c)) {
                mapPosition.put(c, i);
            }
        }
        //TODO: sanitize
        //min index
        int index= Integer.MAX_VALUE;
        for (char c:countElementsMap.keySet()) {
            if(countElementsMap.get(c) > 1) { //recurrent
                int pos = mapPosition.get(c);
                index = Math.min(index, pos);
            }
        }

        if(index != Integer.MAX_VALUE) {
            return string.charAt(index);
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("ABCA")); // A
        System.out.println(solution("BCABA")); //B
        System.out.println(solution("glovol"));//l
        System.out.println(solution("ABC")); //null
    }
}
