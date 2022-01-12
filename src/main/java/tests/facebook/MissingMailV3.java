package tests.facebook;

import java.util.HashMap;
import java.util.Map;

class MissingMailV3 {

    public static double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        Map<Integer, Map<Double, Double>> mapCalculatedValues = new HashMap<>();

        return calculateDay(1, N, V, C, S, mapCalculatedValues, 0.0);
    }

    private static double calculateDay(int day, int N, int[] V, int C, double S, Map<Integer, Map<Double, Double>> mapCalculatedValues, double acc) {
        Double storedValue = load(mapCalculatedValues, day, acc);
        if (storedValue != null) {
            return storedValue;
        }
        if (day == N) {
            double value = Math.max(V[day-1] - C + acc, 0);
            save(mapCalculatedValues, day, acc, value);
            return value;
        } else {
            double value1 = V[day-1] - C + calculateDay(day+1, N, V, C, S, mapCalculatedValues, acc);
            double value2 = calculateDay(day+1, N, V, C, S, mapCalculatedValues, (1-S) * (V[day-1] + acc));
            return Math.max(value1, value2);
        }
    }

    private static Double load(Map<Integer, Map<Double, Double>> mapCalculatedValues, int day, double key) {
        Map<Double, Double> map = mapCalculatedValues.get(day);
        if (map == null) return null;
        return map.get(key);

    }

    private static void save(Map<Integer, Map<Double, Double>> mapCalculatedValues, int day, double acc, double value) {
        Map<Double, Double> map = mapCalculatedValues.get(day);
        if (map == null) map = new HashMap<>();
        map.put(acc, value);
        mapCalculatedValues.put(day, map);
    }

    public static void main(String[] args) {
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 5, 0.0)); //25.00
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 5, 1.0)); //9.00
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 3, 0.5)); //17.00
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,4}, 3, 0.15)); //20.10

        System.out.println(getMaxExpectedProfit(1, new int[]{10}, 11, 0.15)); //0
        System.out.println(getMaxExpectedProfit(5, new int[]{10,2,8,6,0}, 4, 0.5)); //13
        System.out.println(getMaxExpectedProfit(3, new int[]{10,0,2}, 6, 0.05)); //5.x

    }

}