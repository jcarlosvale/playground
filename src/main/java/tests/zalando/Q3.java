package tests.zalando;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3 {
    public static int solution(int[] A) {
        List<Integer> listOfElements = new ArrayList<>();
        Map<Integer, List<Integer>> mapIndexes = new HashMap<>();
        for (int i = 1; i < A.length - 1; i++) {
            listOfElements.add(A[i]);
            List<Integer> indexes = mapIndexes.getOrDefault(A[i], new ArrayList<>());
            indexes.add(i);
            mapIndexes.put(A[i], indexes);
        }
        listOfElements.sort(Integer::compareTo);

        int minimum1 = listOfElements.get(0);
        int minimum2 = -1;
        for (int i = 1; i < listOfElements.size(); i++) {
            if(isNotAdjacent(mapIndexes.get(minimum1), mapIndexes.get(listOfElements.get(i)))){
                minimum2 = listOfElements.get(i);
                break;
            }
        }
        return minimum1 + minimum2;
    }

    private static boolean isNotAdjacent(List<Integer> indexes1, List<Integer> indexes2) {
        for (int index1: indexes1) {
            for(int index2: indexes2) {
                if(Math.abs(index1 - index2) > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,2,4,6,3,7})); //5
        System.out.println(solution(new int[]{5,4,3,2,1})); //6
    }
}
