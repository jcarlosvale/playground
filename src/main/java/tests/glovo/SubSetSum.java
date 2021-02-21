package tests.glovo;

import java.util.HashSet;
import java.util.Set;

public class SubSetSum {
    public static boolean CaterpillarSearch(int[] array, int expectedSearch)
    {
        int head = 0;
        int tail = 0;
        int currentSum = 0;

        while (expectedSearch != currentSum && head < array.length)
        {
            if (currentSum < expectedSearch)
            {
                currentSum += array[head];
                head++;
            }
            else
            {
                currentSum -= array[tail];
                tail++;
            }
        }

        return expectedSearch == currentSum;
    }

    public static boolean solution(int[] array, int expectedSum) {
        int n = array.length;
        int front = 0, total = 0;
        for (int back = 0; back < n; back++) {
            while (front < n && total+array[front] <= expectedSum) {
                total += array[front];
                front++;
            }
            if (total == expectedSum){
                return true;
            }
            total -= array[back];
        }
        return false;
    }

    // Function to check if subarray with zero-sum is present in a given array or not
    public static Boolean hasZeroSumSubarray(int[] A) {
        // create an empty set to store the sum of elements of each
        // subarray `A[0…i]`, where `0 <= i < arr.length`
        Set<Integer> set = new HashSet<>();

        // insert 0 into the set to handle the case when subarray with
        // zero-sum starts from index 0
        set.add(0);

        int sum = 0;

        // traverse the given array
        for (int value: A) {
            // sum of elements so far
            sum += value;

            // if the sum is seen before, we have found a subarray with zero-sum
            if (set.contains(sum)) {
                return true;
            }

            // insert sum so far into the set
            set.add(sum);
        }

        // we reach here when no subarray with zero-sum exists
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[] {4,2,-3,1,6}, 0)); //true
//        System.out.println(solution(new int[] {4,2,0,1,6}, 0)); //true
//        System.out.println(solution(new int[] {-3,2,3,1,6}, 0)); //false
//
//        System.out.println(CaterpillarSearch(new int[] {4,2,-3,1,6}, 0)); //true
//        System.out.println(CaterpillarSearch(new int[] {4,2,0,1,6}, 0)); //true
//        System.out.println(CaterpillarSearch(new int[] {-3,2,3,1,6}, 0)); //false

        System.out.println(hasZeroSumSubarray(new int[] {4,2,-3,1,6})); //true
        System.out.println(hasZeroSumSubarray(new int[] {4,2,0,1,6})); //true
        System.out.println(hasZeroSumSubarray(new int[] {-3,2,3,1,6})); //false

    }

}
