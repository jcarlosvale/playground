package tests.codility;

import java.util.HashSet;

public class MissingInteger {
    public static int solution(int[] A) {
        int min = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }
        for (int i = 1; i < 1_000_000; i++) {
            if (!set.contains(i)) {
                min = i;
                break;
            }
        }
        return min;
    }
}
