package tests.facebook.interviewbits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByColor {

    public static void sortColors(ArrayList<Integer> a) {
        Map<Integer, Integer> colorCount = new HashMap<Integer, Integer>();
        //count
        for(int i : a) {
            colorCount.put(i, colorCount.getOrDefault(i, 0) + 1);
        }
        //fill
        int index = 0;
        int count = colorCount.getOrDefault(0, 0);
        fill(a, 0, index, count);
        if (count > 0) index += count;

        count = colorCount.getOrDefault(1, 0);
        fill(a, 1, index, count);
        if (count > 0) index += count;

        count = colorCount.getOrDefault(2, 0);
        fill(a, 2, index, count);
    }

    public static void fill(ArrayList<Integer> a, int value, int index, int count) {
        if (count <= 0) return;
        while(count > 0) {
            a.set(index, value);
            index++;
            count--;
        }
    }

    public static void main(String[] args) {
        sortColors(new ArrayList<>(List.of(0)));
        sortColors(new ArrayList<>(List.of(2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1, 2, 1, 2, 2, 1,
                0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2, 1, 1, 1, 2, 0, 1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1,
                2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 1, 0, 2, 1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2,
                1, 0, 2, 2, 1, 1, 0, 2, 1, 2 )));
    }
}
