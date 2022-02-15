package tests.facebook.preparation;

import java.util.HashMap;
import java.util.Map;

public class PairSums {

    static int numberOfWays(int[] arr, int k) {
        int ans = 0;
        final Map<Integer, Integer> mapOfInteger = new HashMap<>();
        for (int i : arr) {
            int count = mapOfInteger.getOrDefault(k-i, 0);
            ans += count;
            mapOfInteger.put(i, count+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(new int[]{1, 2, 3, 4, 3}, 6));//2
        System.out.println(numberOfWays(new int[]{1, 5, 3, 3, 3}, 6));//4
    }
}
