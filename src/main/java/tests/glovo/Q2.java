package tests.glovo;

import java.util.Arrays;

public class Q2 {

    //O(n log n)
    //O(n)
    public static int[] solution(int[] array) {
        Arrays.sort(array); //n log n
        int length = array.length;
        int [] result = new int[array.length];

        if (length <= 1) {
            return array;
        }

        if (length <= 2) {
            if(array[1] < array[0]) {
                result[0] = array[1];
                result[1] = array[0];
            }
            result = array;
        }

        //logic
        int middle= length / 2;
        int index1 = 0;
        int index2 = middle;
        int pos = 0;

        while(index1 < middle) {
            result[pos] = array[index1];
            index1++;
            pos++;
            result[pos] = array[index2];
            index2++;
            pos++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {5,2,1,7,9,8})));

        System.out.println(Arrays.toString(solution(new int[] {1,2,3,4,5,6})));

    }

    //1 2 5 7 8 9
    //1

}
