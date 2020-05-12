package tests.hackerrank;

import tests.leetcode.challenge30days.FirstUnique;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * You are given an array and you need to find number of tripets of indices  such that the elements at those indices
 * are in geometric progression for a given common ratio  and .
 *
 * For example, . If , we have  and  at indices  and .
 *
 * Function Description
 *
 * Complete the countTriplets function in the editor below. It should return the number of triplets forming a
 * geometric progression for a given  as an integer.
 *
 * countTriplets has the following parameter(s):
 *
 * arr: an array of integers
 * r: an integer, the common ratio
 * Input Format
 *
 * The first line contains two space-separated integers  and , the size of  and the common ratio.
 * The next line contains  space-seperated integers .
 *
 * Constraints
 *
 * Output Format
 *
 * Return the count of triplets that form a geometric progression.
 *
 * Sample Input 0
 *
 * 4 2
 * 1 2 2 4
 * Sample Output 0
 *
 * 2
 * Explanation 0
 *
 * There are  triplets in satisfying our criteria, whose indices are  and
 *
 * Sample Input 1
 *
 * 6 3
 * 1 3 9 9 27 81
 * Sample Output 1
 *
 * 6
 * Explanation 1
 *
 * The triplets satisfying are index , , , ,  and .
 *
 * Sample Input 2
 *
 * 5 5
 * 1 5 5 25 125
 * Sample Output 2
 *
 * 4
 * Explanation 2
 *
 * The triplets satisfying are index , , , .
 */
public class CountTripletsGeometricProgression {
    public CountTripletsGeometricProgression() throws IOException {
    }

    static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        //count numbers
        TreeMap<Long, Long> treeMap = new TreeMap<>();

        List<long[]> listOptions = new ArrayList<>();

        for (long i: arr) {
            treeMap.put(i, treeMap.getOrDefault(i,0L) + 1L);
        }
        //identify triplets
        if(r == 1) {
            for (Long i: treeMap.keySet()) {
                if (treeMap.get(i) > 2) {
                    long n = treeMap.get(i);
                    count += (n * (n-1) * (n-2)) /  6;
                }
            }
        } else {
            for (Long i: treeMap.keySet()) {
                count += treeMap.get(i) *
                        treeMap.getOrDefault(i * r, 0L) *
                        treeMap.getOrDefault(i * r * r, 0L);

                if (treeMap.containsKey(i) && treeMap.containsKey(i*r) && treeMap.containsKey(i*r*r)) {
                    listOptions.add(new long[]{i, i*r, i*r*r});
                    System.out.println("keys: " + i + " " + i*r + " " + i*r*r);
                    System.out.println("count: " + treeMap.get(i) + " " + treeMap.get(i*r) + " " + treeMap.get(i*r*r));
                    System.out.println("sum: " + (treeMap.get(i) * treeMap.get(i*r) * treeMap.get(i*r*r)));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        List<Long> nums = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            nums.add(1L);
//        }
//        System.out.println(countTriplets(nums, 1)); //100 1s 1 161700

        InputStream inputStream = FirstUnique.class.getClassLoader().getResourceAsStream("inputTriplets-1.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String line = br.readLine();
        String[] numbers = line.split(" ");
        int size = Integer.parseInt(numbers[0]);
        int r = Integer.parseInt(numbers[1]);

        line = br.readLine();
        nums.clear();
        for (String value : line.split(" ")) {
            nums.add(Long.parseLong(value));
        }
        if (nums.size() == size) {
            long value = countTriplets(nums, r);  //13_621_903_916
            System.out.println(value); //2325652489
            System.out.println("difference " + (value - 2_325_652_489L));
        } else{
            System.out.println("error reading file");
        }
/*
        nums.clear();

        nums.addAll(Arrays.asList(1L,1L,3L,3L,9L,9L, 27L, 27L));
        System.out.println(countTriplets(nums, 3));  //16
*/
    }
}
