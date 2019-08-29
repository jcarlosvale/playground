package tests.complyAdvantage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IdenticalPair {

    public static int solution(int[] A) {
        Map<Integer, Integer> counterMap  = new HashMap<>();
        long sum = 0;
        for (int element:A) {
            Integer count = counterMap.get(element);
            if (null != count) {
                counterMap.put(element,++count);
            } else {
                counterMap.put(element,1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            sum = sum + calculatePossibilites(entry.getValue());
            if (sum >= 1_000_000_000) return 1_000_000_000;
        }

        return (int) sum;
    }

    private static long calculatePossibilites(int value) {
        return (value*value - value)/2;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,5,6,3,3,5}));
    }

}
