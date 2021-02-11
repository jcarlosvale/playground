package tests.microsoft;

public class BinaryFind {

    // you can also use imports, for example:
    // import java.util.*;

    public static int binarySearch(int[]numbers, int start, int end) {
        if (end < start) return start+1;
        int middle = start + (end-start) / 2;
        if(middle+1  == numbers[middle]) {
            return binarySearch(numbers, middle+1, end);
        } else {
            return binarySearch(numbers, start, middle-1);
        }
    }

    public static int solution(int [] numbers) {
        // int missing = 1;

        // if(numbers[0] != 1) return 1;
        // if(numbers[1] != 2) return 2;

        // //number[index] = index+1;

        // //binarySearch(index+1, numbers, )
        // for(int i = 0; i < numbers.length; i++) {
        //     int elem = numbers[i];
        //     if(missing != elem) {
        //         return missing;
        //     }
        //     missing++;
        // }

        return binarySearch(numbers, 0, numbers.length-1);
    }

    public static void main(String [] args) {
        System.out.println("This is a debug message");
        System.out.println(solution(new int[]{1,2,3,5}));  //4
        System.out.println(solution(new int[]{2,3,4,5}));  //1
    }
}

