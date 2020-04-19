package tests.leetcode.challenge30days;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 *
 * If there're duplicates in arr, count them seperately.
 */
public class CountingElements {

    public static int countElements(int[] arr) {
        int count = 0;
        Map<Integer, Integer> mapOfElements = new HashMap<>();
        //mapping the elements
        for(int i: arr) {
            int cont = 1;
            if (mapOfElements.containsKey(i)) {
                cont = mapOfElements.get(i) + 1;
            }
            mapOfElements.put(i, cont);
        }
        //counting
        for(int i: arr) {
            if (mapOfElements.containsKey(i+1)) {
                count++;
                mapOfElements.put(i+1, mapOfElements.get(i)-1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1,2,3})); //2
        System.out.println(countElements(new int[]{1,1,3,3,5,5,7,7})); //0
        System.out.println(countElements(new int[]{1,3,2,3,5,0})); //3
        System.out.println(countElements(new int[]{1,1,2,2})); //2
    }
}
