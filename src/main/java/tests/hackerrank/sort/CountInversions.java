package tests.hackerrank.sort;

import java.util.List;

public class CountInversions {

    public static long countInversions(List<Integer> arr) {
        long count = 0;
        boolean swap;
        do {
            swap = false;
            for(int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i+1)) {
                    swap = true;
                    count++;
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i+1));
                    arr.set(i+1, temp);
                }
            }
        } while(swap);

        return count;
    }
}
