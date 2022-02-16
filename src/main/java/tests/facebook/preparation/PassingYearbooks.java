package tests.facebook.preparation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PassingYearbooks {

    public static int[] findSignatureCounts(int[] arr) {
        int[] output = new int[arr.length];

        for(int student =1; student <= arr.length;student++){
            int bookOwner= student;
            int currentHolder = student;

            do{
                output[student-1] +=1;
                currentHolder = arr[currentHolder-1];
            }while(currentHolder != bookOwner);

        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSignatureCounts(new int[]{2,1}))); //{2,2}
    }
}
