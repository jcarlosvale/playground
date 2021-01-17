package tests.microsoft.mario;

import java.util.HashMap;
import java.util.Map;

public class MaxSum {
    public static int solution(int[] A) {
        Map<Integer, int[]> mapOfSum = new HashMap<>();
        int result = -1;
        if (A.length == 1) {
            return -1;
        }
        for (int i = 0; i < A.length; i++) {
            int number = A[i];
            int sumDigit = sumOfDigits(number);
            int[] values = mapOfSum.getOrDefault(sumDigit, new int[2]);
            if (values[0] == 0) {
                values[0] = number;
            } else {
                if (values[1] == 0) {
                    values[1] = number;
                } else {
                    int min = Math.min(number, Math.min(values[0], values[1]));
                    if (min  == values[0]) {
                        values[0] = number;
                    } else {
                        if (min == values[1]) {
                            values[1] = number;
                        }
                    }
                }
            }
            mapOfSum.put(sumDigit, values);
            if (values[0] > 0 && values[1] > 0) result = Math.max(result, values[0] + values[1]);
        }
        return result;
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {51, 71, 17, 42})); //93
        System.out.println(solution(new int[] {42, 33, 60})); //102
        System.out.println(solution(new int[] {51, 32, 43})); //-1
    }
}
