package tests.trinet;

import java.util.*;

/**
 * // Given a list of positive integers, split them into two groups so that the sums of the integers
 * // in each group are similar.
 *
 * // Input 1: [10,3,7,1,1,8] --> 2 lists that sum up to 15 each
 * // Output 1: [10,3,1,1],[7,8]
 */
public class TwoSetSameSum {

    public static void split(int [] array) {
        int sum = 0;
        int division = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int sum1 = 0;

        for(int i: array) sum += i;

        division = sum / 2;

        for(int i: array) {
            if ((sum1 < division) && (sum1 + i <= division)){
                list1.add(i);
                sum1 += i;
            }
            else list2.add(i);
        }

        System.out.println(list1);
        System.out.println(list2);
    }

    public static void main(String[] args) {
        split(new int[]{10,3,7,1,1,8});
    }
}
