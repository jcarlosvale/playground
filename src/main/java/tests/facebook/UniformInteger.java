package tests.facebook;

import java.util.Arrays;

class UniformInteger {

    public static int getUniformIntegerCountInInterval(long A, long B) {
        int count;
        String lower = String.valueOf(A);
        String higher = String.valueOf(B);
        count = (higher.length() - lower.length() + 1) * 9; //total possible
        //analysis of lower
        int diff = lower.charAt(0) - '0';  //get digit
        count -= (diff+1);
        //analysis of higher
        diff = higher.charAt(0) - '0';  //get digit
        count -= (9 - diff);
        //verify if the limits belongs
        char [] lowerChar = new char[lower.length()];
        Arrays.fill(lowerChar, lower.charAt(0));
        if(Long.parseLong(new String(lowerChar)) >= A) count++;

        char [] higherChar = new char[higher.length()];
        Arrays.fill(higherChar, higher.charAt(0));
        if(Long.parseLong(new String(higherChar)) <= B) count++;


        return count;
    }

    public static void main(String[] args) {
        System.out.println(getUniformIntegerCountInInterval(75, 300)); //5
        System.out.println(getUniformIntegerCountInInterval(1, 9)); //9
        System.out.println(getUniformIntegerCountInInterval(999999999999L, 999999999999L)); //1
    }
}