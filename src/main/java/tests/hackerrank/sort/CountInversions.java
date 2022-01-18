package tests.hackerrank.sort;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    public static long countInversions(List<Integer> arr) {
        return mergeSort(arr);
    }

    private static long mergeSort(List<Integer> arr) {
        long count = 0;
        int n = arr.size();
        if (n < 2) {
            return 0;
        }

        int mid = n / 2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            left.add(arr.get(i));
        }

        for (int i = mid; i < n; i++) {
            right.add(arr.get(i));
        }

        count += mergeSort(left);
        count += mergeSort(right);

        count += merge(arr, left, right);

        return count;
    }

    private static long merge(List<Integer> arr, List<Integer> left, List<Integer> right) {
        int leftSize = left.size();
        int rightSize = right.size();
        long count = 0;

        int i = 0, j = 0, k = 0;

        while(i < leftSize && j < rightSize) {
            if (left.get(i) <= right.get(j)) {
                arr.set(k, left.get(i));
                i++;
                k++;
            } else {
                arr.set(k, right.get(j));
                count += (leftSize - k) + j;
                j++;
                k++;
            }
        }

        while(i<leftSize) {
            arr.set(k, left.get(i));
            i++;
            k++;
        }
        while(j<rightSize) {
            arr.set(k, right.get(j));
            j++;
            k++;
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(5);
        list.add(3);
        list.add(1);
        System.out.println(countInversions(list)); //6
    }
}
